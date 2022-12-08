package rs.ac.bg.etf.pp1;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.BoolConst;
import rs.ac.bg.etf.pp1.ast.CharConst;
import rs.ac.bg.etf.pp1.ast.DesignatorArrayExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorIdentOnly;
import rs.ac.bg.etf.pp1.ast.DesignatorParamsAssignopExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorParamsDec;
import rs.ac.bg.etf.pp1.ast.DesignatorParamsInc;
import rs.ac.bg.etf.pp1.ast.DesignatorParamsIncInc;
import rs.ac.bg.etf.pp1.ast.DesignatorReverse;
import rs.ac.bg.etf.pp1.ast.Div;
import rs.ac.bg.etf.pp1.ast.ExprClass;
import rs.ac.bg.etf.pp1.ast.ExprExprIsNullClass;
import rs.ac.bg.etf.pp1.ast.ExprNegative;
import rs.ac.bg.etf.pp1.ast.FactorBool;
import rs.ac.bg.etf.pp1.ast.FactorChar;
import rs.ac.bg.etf.pp1.ast.FactorMaxArray;
import rs.ac.bg.etf.pp1.ast.FactorNewTypeExpr;
import rs.ac.bg.etf.pp1.ast.FactorNum;
import rs.ac.bg.etf.pp1.ast.IsNull;
import rs.ac.bg.etf.pp1.ast.ListAddopTerms;
import rs.ac.bg.etf.pp1.ast.ListMulopFactors;
import rs.ac.bg.etf.pp1.ast.MethodDeclr;
import rs.ac.bg.etf.pp1.ast.MethodRetType;
import rs.ac.bg.etf.pp1.ast.MethodVoid;
import rs.ac.bg.etf.pp1.ast.Mul;
import rs.ac.bg.etf.pp1.ast.NoExpr;
import rs.ac.bg.etf.pp1.ast.NumConst;
import rs.ac.bg.etf.pp1.ast.Plus;
import rs.ac.bg.etf.pp1.ast.PrintExprNumStatement;
import rs.ac.bg.etf.pp1.ast.PrintExprStatement;
import rs.ac.bg.etf.pp1.ast.ReadStatement;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	private SemanticAnalyzer semA;

	class HelpIfNull {
		int value;
		int isChange;

		public HelpIfNull(int v, int c) {
			value = v;
			isChange = c;
		}
	}

	LinkedList<HelpIfNull> ifNullList;

	// HELP FUNCTIONS FOR REPORTING INFORMATION
	// ********************************************************************************************************
	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	private int mainPc;

	public int getMainPc() {
		return mainPc;
	}

	public CodeGenerator(SemanticAnalyzer s) {
		this.semA = s;
		ifNullList = new LinkedList<HelpIfNull>();

		// we need to generate code for ord, chr and len functions
		// ord
		Obj ordObj = Tab.find("ord");
		ordObj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(ordObj.getLevel());
		Code.put(ordObj.getLocalSymbols().size());
		Code.put(Code.load_n); // push local variable
		Code.put(Code.exit);
		Code.put(Code.return_);

		// chr
		Obj chrObj = Tab.find("chr");
		ordObj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(chrObj.getLevel()); // number of arguments
		Code.put(chrObj.getLocalSymbols().size()); // number of arguments and local variables
		Code.put(Code.load_n); // push local variable
		Code.put(Code.exit);
		Code.put(Code.return_);

		// len
		Obj lenObj = Tab.find("len");
		ordObj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(lenObj.getLevel()); // number of arguments
		Code.put(lenObj.getLocalSymbols().size()); // number of arguments and local variables
		Code.put(Code.load_n); // push local variable
		Code.put(Code.arraylength);
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	// METHOD
	// *************************************************************************************
	public void visit(MethodVoid methodVoid) {
		// report_info("methodVoid", methodVoid);
		if (methodVoid.getMethodName().equals("main")) {
			mainPc = Code.pc;
			Code.mainPc = mainPc;
		}

		// we should set address where this method in Code is
		methodVoid.obj.setAdr(Code.pc);

		Code.put(Code.enter);
		Code.put(methodVoid.obj.getLevel()); // number of arguments
		Code.put(methodVoid.obj.getLocalSymbols().size()); // number of local parameters and arguments

	}

	public void visit(MethodRetType methodRetType) {
		// we should set address where this method in Code is
		// report_info("methodRetType", methodRetType);
		methodRetType.obj.setAdr(Code.pc);

		Code.put(Code.enter);
		Code.put(methodRetType.obj.getLevel()); // number of arguments
		Code.put(methodRetType.obj.getLocalSymbols().size()); // number of local parameters and arguments
	}

	public void visit(MethodDeclr methodDeclr) {
		// report_info("methodDeclr", methodDeclr);
		if (methodDeclr.getMethodBegin() instanceof MethodVoid) {
			MethodVoid metV = (MethodVoid) methodDeclr.getMethodBegin();
			String name = metV.getMethodName();
			if (name.equals("main")) {
				Code.dataSize = this.semA.globalVars;
				Code.mainPc = mainPc;
			}
		}
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	// PRINT
	// *************************************************************************************
	public void visit(PrintExprStatement printExprStatement) {
		// first - width
		// second - print/brint - instruction code
		// report_info("PrintExprStatement", printExprStatement);
		Code.loadConst(5); // width is 4: 4B=32b -> one word, but I want space, so it is 5

		if (printExprStatement.getExpr().struct.equals(Tab.charType)) {
			Code.put(Code.bprint);
		} else
			Code.put(Code.print);
	}

	public void visit(PrintExprNumStatement printExprStatement) {
		// first - width
		// second - print/brint - instruction code
		// report_info("PrintExprNumStatement", printExprStatement);
		Code.loadConst(printExprStatement.getNumConst().getNumberValue());

		if (printExprStatement.getExpr().struct.equals(Tab.charType)) {
			Code.put(Code.bprint);
		} else
			Code.put(Code.print);
	}

	// READ
	// *************************************************************************************
	public void visit(ReadStatement readStatement) {
		// write instruction code: read/bread
		// and read value from Expr. Stack and put that in
		// readStatement.getDesignator().obj - store
		// report_info("ReadStatement", readStatement);
		if (readStatement.getDesignator().obj.getType().getKind() == Struct.Char) {
			Code.put(Code.bread);
		} else
			Code.put(Code.read);
		Code.store(readStatement.getDesignator().obj);
	}

	// EXPRESSIONS
	// *************************************************************************************
	public void visit(ExprNegative term) {
		// report_info("CODE_GEN: ExprNegative", term);
		Code.put(Code.neg);
	}

	public void visit(FactorNum factorNum) {
		// report_info("CODE_GEN: FactorNum", factorNum);
		Code.load(new Obj(Obj.Con, "", Tab.intType, factorNum.getN1(), 0));
	}

	public void visit(FactorChar factorChar) {
		// report_info("CODE_GEN: FactorChar", factorChar);
		Code.load(new Obj(Obj.Con, "", Tab.charType, factorChar.getC1(), 0));
	}

	public void visit(FactorBool factorBool) {
		// report_info("CODE_GEN: FactorBool", factorBool);
		Code.load(new Obj(Obj.Con, "", SemanticAnalyzer.boolStruct, factorBool.getB1() ? 1 : 0, 0));
	}

	public void visit(ExprClass expr) {
		// report_info("CODE_GEN: ExprClass, parent: " + expr.getParent(), expr);
		if (expr.getExprIsNull() instanceof NoExpr && expr.getParent() instanceof ExprExprIsNullClass) {

			for (int i = 0; i < ifNullList.size(); i++) {
				if (ifNullList.get(i).isChange == 0) {
					// System.out.println("**************************************************************************************************");
					// System.out.println("FROM ifNullList IS PROCESSING:" +
					// ifNullList.get(i).value);
					ifNullList.get(i).isChange = 1;
					Code.fixup(ifNullList.get(i).value);
				}
			}

		} else {
			// System.out.println("ExprClass nije ni obradjivan");
		}
	}

	public void visit(IsNull isNull) {
		// report_info("CODE_GEN: IsNull", isNull);
		Code.put(Code.dup); // put dup to Expr. Stack

		Code.loadConst(0); // put 0 to Expr. Stack
		Code.putFalseJump(Code.eq, 0);
		// if first argument are NOT 0, it is jump
		// if first argument are zero, it is not jump

		// dup will duplicate last element on Expr Stck - which is first argument in
		// expresson
		// Expr Stack : first, 0, opCodeJump, offset, offset0
		// jmp will remove first and zero

		HelpIfNull newOne = new HelpIfNull(Code.pc - 2, 0);
		this.ifNullList.add(newOne);

		// System.out.println("**************************************************************************************************");
		// System.out.println("IN ifNullList ADDED:" + (Code.pc - 2));

		Code.put(Code.pop);
	}

	public void visit(ListAddopTerms addop) {
		// report_info("CODE_GEN: ListAddopTerms", addop);
		if (addop.getAddop() instanceof Plus) {
			Code.put(Code.add);
		} else
			Code.put(Code.sub);
	}

	public void visit(ListMulopFactors mulop) {
		// report_info("CODE_GEN: ListMulopFactors", mulop);
		if (mulop.getMulop() instanceof Mul) {
			Code.put(Code.mul);
		} else if (mulop.getMulop() instanceof Div) {
			Code.put(Code.div);
		} else
			Code.put(Code.rem);
	}

	public void visit(FactorNewTypeExpr newArr) {
		// on Expr Stack is already length of an array
		// report_info("CODE_GEN: FactorNewTypeExpr", newArr);
		Code.put(Code.newarray);
		// instruction newarray has one argument:
		// 0 if it is array of chars,
		// or 1 if it is array of words
		if (newArr.getType().struct.equals(Tab.charType)) {
			Code.put(0);
		} else
			Code.put(1);
	}

	// DESIGNATOR
	// *************************************************************************************
	public void visit(DesignatorParamsAssignopExpr des) {
		// on Expr Stack are arguments
		/*
		 * report_info("CODE_GEN: DesignatorParamsAssignopExpr kind=" +
		 * SemanticAnalyzer.PrintTypeObj[des.getDesignator().obj.getKind()] + " , name="
		 * + des.getDesignator().obj.getName() + ", type=" +
		 * SemanticAnalyzer.PrintTypeStruct[des.getDesignator().obj.getType().getKind()]
		 * + ", adr=" + des.getDesignator().obj.getAdr() + ", level=" +
		 * des.getDesignator().obj.getLevel() + ", locals=" +
		 * des.getDesignator().obj.getLocalSymbols().size(), des);
		 */
		Code.store(des.getDesignator().obj);
	}

	public void visit(DesignatorParamsInc des) {
		// report_info("CODE_GEN: DesignatorParamsInc", des);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(des.getDesignator().obj);
	}

	public void visit(DesignatorParamsDec des) {
		// report_info("CODE_GEN: DesignatorParamsDec", des);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(des.getDesignator().obj);
	}

	public void visit(DesignatorIdentOnly des) {
		// we should not load value if it is on the left side in DesignatorReverse
		/*
		 * if (des.getParent() instanceof DesignatorReverse) return;
		 */

		// we should not load value if it is part of read statement
		// that we will store in variable in ReadStatement
		// report_info("CODE_GEN: DesignatorIdentOnly", des);
		// System.out.println("des.getParent=" + des.getParent().getClass() + ",
		// des.getName()=" + des.getDesignatorName()
		// + ", kind=" + SemanticAnalyzer.PrintTypeObj[des.obj.getKind()] + ", type="
		// + SemanticAnalyzer.PrintTypeStruct[des.obj.getType().getKind()]);
		if (des.getParent() instanceof ReadStatement)
			return;

		// we should not load value if it is on the left side in assign statement
		// but we have to put on Expr Stack the address od an array -> &&
		// des.obj.getType().getKind()!=Struct.Array
		if (des.getParent() instanceof DesignatorParamsAssignopExpr)
			return;

		// we should not load value if it method name
		if (des.obj.getKind() == Obj.Meth)
			return;

		// System.out.println("DesignatorIdentOnly, we put on ExprStack: kind="
		// + SemanticAnalyzer.PrintTypeObj[des.obj.getKind()] + " , name=" +
		// des.obj.getName() + ", type="
		// + SemanticAnalyzer.PrintTypeStruct[des.obj.getType().getKind()] + ", adr=" +
		// des.obj.getAdr()
		// + ", level=" + des.obj.getLevel() + ", locals=" +
		// des.obj.getLocalSymbols().size());

		Code.load(des.obj);
	}

	public void visit(DesignatorArrayExpr des) {
		// we should not load value if it is part of read statement
		// that we will store in variable in ReadStatement
		// report_info("CODE_GEN: DesignatorArrayExpr", des);
		if (des.getParent() instanceof ReadStatement)
			return;

		// we should not load value if it is on the left side in assign statement
		if (des.getParent() instanceof DesignatorParamsAssignopExpr)
			return;

		Code.load(des.obj);
	}

	/*
	 * public void visit(DesignatorReverse des) { // niz~i ==> niz[i] = niz[i] +
	 * niz[niz.length - i]
	 * 
	 * 
	 * // niz[i] -> za pristup elementu niza koristimo aload // na Expr. Stak-u:
	 * adrNiza, indx // pa aload koji skine adrNiza i indx // i ostavi samo
	 * odgovarajuci val
	 * 
	 * // ...=niz[i] -> za upis u element niza koristimo astore // na Expr. Stack-u:
	 * adrNiza, indx, val // pa astore pokupi sve sa steka i upise odgovarajucu
	 * vrednost
	 * 
	 * int indx = des.getNumConst().getNumberValue();
	 * Code.load(des.getDesignator().obj); //adresa niza Code.loadConst(indx);
	 * //indx
	 * 
	 * //na steku smo ostavili adresu i indx //treba jos da upisemo vrednost
	 * 
	 * //dohvatamo prvo niz[i] Code.load(des.getDesignator().obj); //adresa niza
	 * Code.loadConst(indx); //indx Code.put(Code.aload); // sada na E Stack-u
	 * ostala vr. niz[i]
	 * 
	 * //dohvatamo niz[niz.length-i] Code.load(des.getDesignator().obj); //adresa
	 * niza Code.load(des.getDesignator().obj); //adresa niza //SE MORA PODMETNUTI
	 * JOS JEDNOM //JER ZA arraylength NA ESTACKU TREBA DA STOJI ADRESA NIZA
	 * Code.put(Code.arraylength); //duzina niza Code.loadConst(indx); //i
	 * Code.put(Code.sub); // length-i ostalo na E Stack-u, tj. indx
	 * Code.put(Code.aload); // sada na E Stack-u ostala vr niz[length - i]
	 * 
	 * Code.put(Code.add); // na E Stack-u: niz[i]+niz[length - i]
	 * 
	 * // na E Stack-u nam je adr, indx, val ==> jos samo astore
	 * Code.put(Code.astore); }
	 * 
	 * public void visit(DesignatorParamsIncInc des) {
	 * //report_info("CODE_GEN: DesignatorParamsInc", des); Code.loadConst(2);
	 * Code.put(Code.add); Code.store(des.getDesignator().obj); }
	 * 
	 * public void visit(FactorMaxArray des) {
	 * 
	 * 
	 * //dohvatamo prvi element //znaci adr, indx ==> pa aload
	 * Code.load(des.getDesignator().obj); //adr Code.loadConst(0); //indx
	 * Code.put(Code.aload); // aload uzim adr i indx
	 * 
	 * // sada na EStacku samo niz[0] // EStack: niz[0]
	 * 
	 * //pravimo niz[0] adr 0 i pokrecemo loop Code.load(des.getDesignator().obj);
	 * // niz[0] adr Code.loadConst(0); // niz[0] adr 0 int loop = Code.pc; //
	 * pokrenuli smo loop
	 * 
	 * //proveravamo da li len==1 Code.loadConst(1); //niz[0] adr 0 1
	 * Code.load(des.getDesignator().obj); //niz[0] adr 0 1 adr
	 * Code.put(Code.arraylength); //niz[0] adr 0 1 len
	 * 
	 * //putFalseJump skine 2 elem-a sa steka Code.putFalseJump(Code.ne, 0); //
	 * niz[0] adr 0 // proverava se 1==len? int end = Code.mainPc - 2; //pokazuje na
	 * niz[0]
	 * 
	 * 
	 * Code.put(Code.pop); // niz[0] adr Code.loadConst(1); // niz[0] adr 1
	 * Code.put(Code.aload); // niz[0] niz[1]
	 * 
	 * //sada cemo niz[0] niz[1] duplirati na steku //i vrsiti proveru niz[0]>niz[1]
	 * Code.put(Code.dup2); // niz[0] niz[1] niz[0] niz[1]
	 * Code.putFalseJump(Code.le, 0); // niz[0] niz[1] //proverava se niz[0]>niz[1]
	 * 
	 * int grana1 = Code.pc - 1; //pokazuje ispred niz[0]
	 * 
	 * //cilj napraviti niz[1] adr 1 Code.put(Code.dup_x1); // niz[1] niz[0] niz[1]
	 * Code.put(Code.pop); Code.put(Code.pop); // niz[1]
	 * Code.load(des.getDesignator().obj); // niz[1] adr Code.loadConst(1); //
	 * niz[1] adr 1
	 * 
	 * Code.loadConst(0); Code.loadConst(0); Code.putFalseJump(Code.ne, 0); //niz[1]
	 * adr 1 //provera da li 0==0 -->da int jmpHERE = Code.pc-2; //pok na niz[1]
	 * 
	 * 
	 * //na EStacku niz[1] adr 1 Code.fixup(grana1); //na EStacku niz[1] adr 1 //tj:
	 * val adr indx
	 * 
	 * Code.fixup(jmpHERE); Code.putJump(loop); Code.fixup(end);
	 * 
	 * Code.put(Code.pop); Code.put(Code.pop); Code.put(Code.pop);
	 * 
	 * Code.load(des.getDesignator().obj); Code.loadConst(-1); // adr -1
	 * Code.loadConst(1); // adr -1 1 Code.put(Code.add); // adr 0
	 * Code.load(des.getDesignator().obj); // adr 0 adr Code.put(Code.dup_x2); //adr
	 * adr 0 adr Code.put(Code.pop); // adr adr 0 Code.put(Code.aload); //adr niz[0]
	 * Code.put(Code.dup_x1); // niz[0] adr niz[0] Code.put(Code.pop); // niz[0] adr
	 * Code.loadConst(0); //niz[0] adr 0 int petlja = Code.pc; Code.loadConst(1); //
	 * niz[0] adr 0 1 Code.put(Code.add); // niz[0] adr 1 Code.put(Code.dup_x1); //
	 * niz[0] 1 adr 1 Code.load(des.getDesignator().obj); // niz[0] 1 adr 1 adr
	 * Code.put(Code.arraylength); // niz[0] 1 adr 1 len Code.putFalseJump(Code.ne,
	 * 0); // niz[0] 1 adr, provera 1 == len int krajPetlje = Code.pc - 2;
	 * Code.put(Code.dup_x1); // niz[0] adr 1 adr Code.put(Code.pop); // niz[0] adr
	 * 1 Code.put(Code.dup2); // niz[0] adr 1 adr 1 Code.put(Code.aload); // niz[0]
	 * adr 1 niz[1] Code.put(Code.dup_x2); // niz[0] niz[1] adr 1 niz[1]
	 * Code.put(Code.pop); // niz[0] niz[1] adr 1 Code.put(Code.dup_x1); // niz[0]
	 * niz[1] 1 adr 1 Code.put(Code.pop); Code.put(Code.pop); // niz[0] niz[1] 1
	 * Code.put(Code.dup_x2); // 1 niz[0] niz[1] 1 Code.put(Code.pop); // 1 niz[0]
	 * niz[1] Code.put(Code.dup2); // 1 niz[0] niz[1] niz[0] niz[1]
	 * Code.putFalseJump(Code.le, 0); // 1 niz[0] niz[1], provera niz[0] > niz[1]
	 * int grana1 = Code.pc - 2; Code.put(Code.dup_x1); // 1 niz[1] niz[0] niz[1]
	 * Code.put(Code.pop); // 1 niz[1] niz[0]; Code.put(Code.pop); // 1 niz[1]
	 * Code.put(Code.dup_x1); // niz[1] 1 niz[1] Code.put(Code.pop); // niz[1] 1
	 * Code.load(des.getDesignator().obj); // niz[1] 1 adr Code.put(Code.dup_x1); //
	 * niz[1] adr 1 adr Code.put(Code.pop); // niz[1] adr 1 Code.loadConst(0); //
	 * niz[1] adr 1 0 Code.loadConst(0); // niz[1] adr 1 0 0
	 * Code.putFalseJump(Code.ne, 0); // niz[1] adr 1 //provera 0==0 da - skoci se
	 * ovde int skokOvde = Code.pc - 2; Code.fixup(grana1); // ocekuje se broj adr
	 * index Code.put(Code.pop); // index broj Code.put(Code.dup_x1); // broj index
	 * broj Code.put(Code.pop); // broj index Code.load(des.getDesignator().obj); //
	 * broj index adr Code.put(Code.dup_x1); // broj adr index adr
	 * Code.put(Code.pop); // broj adr index Code.fixup(skokOvde);
	 * Code.putJump(petlja); Code.fixup(krajPetlje); Code.put(Code.pop);
	 * Code.put(Code.pop);
	 * 
	 * }
	 */

}
