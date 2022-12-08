package rs.ac.bg.etf.pp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.ArrayName;
import rs.ac.bg.etf.pp1.ast.BoolConst;
import rs.ac.bg.etf.pp1.ast.BoolConstVal;
import rs.ac.bg.etf.pp1.ast.CharConst;
import rs.ac.bg.etf.pp1.ast.CharConstVal;
import rs.ac.bg.etf.pp1.ast.ConstDeclaration;
import rs.ac.bg.etf.pp1.ast.ConstExp;
import rs.ac.bg.etf.pp1.ast.ConstVal;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorArrayExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorIdentOnly;
import rs.ac.bg.etf.pp1.ast.DesignatorParamsAssignopExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorParamsDec;
import rs.ac.bg.etf.pp1.ast.DesignatorParamsInc;
import rs.ac.bg.etf.pp1.ast.DesignatorParamsIncInc;
import rs.ac.bg.etf.pp1.ast.DesignatorReverse;
import rs.ac.bg.etf.pp1.ast.ExprClass;
import rs.ac.bg.etf.pp1.ast.ExprExprIsNullClass;
import rs.ac.bg.etf.pp1.ast.ExprNegative;
import rs.ac.bg.etf.pp1.ast.ExprPositive;
import rs.ac.bg.etf.pp1.ast.Factor;
import rs.ac.bg.etf.pp1.ast.FactorBool;
import rs.ac.bg.etf.pp1.ast.FactorChar;
import rs.ac.bg.etf.pp1.ast.FactorDesign;
import rs.ac.bg.etf.pp1.ast.FactorExpr;
import rs.ac.bg.etf.pp1.ast.FactorMaxArray;
import rs.ac.bg.etf.pp1.ast.FactorNewTypeExpr;
import rs.ac.bg.etf.pp1.ast.FactorNum;
import rs.ac.bg.etf.pp1.ast.FormParamArr;
import rs.ac.bg.etf.pp1.ast.FormParams;
import rs.ac.bg.etf.pp1.ast.ListAddopTerms;
import rs.ac.bg.etf.pp1.ast.ListMulopFactors;
import rs.ac.bg.etf.pp1.ast.MethodBegin;
import rs.ac.bg.etf.pp1.ast.MethodDeclr;
import rs.ac.bg.etf.pp1.ast.MethodRetType;
import rs.ac.bg.etf.pp1.ast.MethodVoid;
import rs.ac.bg.etf.pp1.ast.NumConst;
import rs.ac.bg.etf.pp1.ast.NumConstVal;
import rs.ac.bg.etf.pp1.ast.OptArg;
import rs.ac.bg.etf.pp1.ast.PrintExprNumStatement;
import rs.ac.bg.etf.pp1.ast.PrintExprStatement;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.ProgramName;
import rs.ac.bg.etf.pp1.ast.ReadStatement;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Term;
import rs.ac.bg.etf.pp1.ast.Type;
import rs.ac.bg.etf.pp1.ast.VarDeclaration;
import rs.ac.bg.etf.pp1.ast.VariableName;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyzer extends VisitorAdaptor {
	public static Struct boolStruct;
	private boolean errorDetected = false;
	private FileOutputStream fileOut;

	public static String[] PrintTypeStruct = { "None", "Int", "Char", "Array", "Class", "Bool", "Enum", "Interface" };
	public static String[] PrintTypeObj = { "Con", "Var", "Type", "Meth", "Fld", "Elem", "Prog" };

	// VARIABLES
	// *********************************************************************************************************

	private enum Levels {
		Program, Class, Method, Null
	};

	private Levels currentLevel;

	private Obj currentType;
	private Obj currentMethod;
	private String methodName;
	int currLevel;
	private int formParamCnt;
	private boolean isThereMain;
	public int globalVars;
	public int localVars;
	public int printCnt;

	// CONSTRUCTOR AND INITIALIZATION
	// *********************************************************************************************************
	public SemanticAnalyzer() {
		File errFile = new File("errors.txt");
		try {
			fileOut = new FileOutputStream(errFile);
			fileOut.write("ERROR NOTES \n".getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isThereMain = false;
		currentLevel = Levels.Null;
		currentType = Tab.noObj;
		currentMethod = Tab.noObj;
		methodName = "";
		formParamCnt = 0;
		currLevel = 0;
		globalVars = 0;
		localVars = 0;
		printCnt = 0;
		Tab.init();
		Tab.openScope();
		boolStruct = new Struct(Struct.Bool);
		// (int kind, String name, Struct type)
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolStruct));
	}

	// HELP FUNCTIONS FOR REPORTING INFORMATION
	// ********************************************************************************************************
	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
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

	public boolean passed() {
		return !errorDetected;
	}

	// PROGRAM
	// ********************************************************************************************************

	public void visit(ProgramName programName) {
		programName.obj = Tab.insert(Obj.Prog, programName.getProgName(), Tab.noType);
		Tab.openScope();
		currentLevel = Levels.Program;
		currLevel = 0;
		report_info("Program name is: " + programName.getProgName(), programName);
	}

	public void visit(Program program) {
		globalVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgramName().obj);
		Tab.closeScope();

		if (isThereMain == false) {
			report_error("There is not main method", null);
			try {
				fileOut.write("There is not main method \n".getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		report_info("Node Program visited", program);
		currentLevel = Levels.Null;
	}

	// VARIABLES
	// *******************************************************************************************************
	public void visit(VariableName varName) {
		Obj varNameObj = Tab.find(varName.getVarName());
		if (varNameObj != Tab.noObj) {
			String text = "Variable name: " + varName.getVarName() + " has already declared \n";
			report_error(text, null);
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		int kind = Obj.Var;
		
		if (currentLevel == Levels.Class) kind = Obj.Fld;
		 

		varNameObj = Tab.insert(kind, varName.getVarName(), currentType.getType());
		int level;
		if(currentLevel == Levels.Program) {
			level = 0;
		}
		else {
			level = 1;
			localVars++;
		}
		varNameObj.setLevel(level);

		report_info("Variable: " + varName.getVarName() + " declared", varName);

	}

	public void visit(ArrayName arrName) {
		Obj arrNameObj = Tab.find(arrName.getArrName());
		if (arrNameObj != Tab.noObj) {
			String text = "Variable array: " + arrName.getArrName() + " has already declared \n";
			report_error(text, null);
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		int kind = Obj.Var;
		if (currentLevel == Levels.Class)
			kind = Obj.Fld;

		arrNameObj = Tab.insert(kind, arrName.getArrName(), new Struct(Struct.Array, currentType.getType()));
		int level;
		if(currentLevel == Levels.Program) {
			level = 0;
		}
		else {
			level = 1;
			localVars++;
		}
		arrNameObj.setLevel(level);

		report_info("Variable array: " + arrName.getArrName() + " declared", arrName);
	}

	public void visit(VarDeclaration varDecl) {
		currentType = Tab.noObj;
		report_info("VarDeclaration visited", varDecl);
	}

	// CONSTANTS
	// *******************************************************************************************************
	public void visit(ConstExp constExp) {
		ConstVal value = constExp.getConstVal();
		// report_info("ConstExpr is visiting... val is: " + value + ", currentType is:
		// " + currentType.getName() + ", currentType.getKind() is: " +
		// currentType.getKind() + ", currentType.getType() is: " +
		// currentType.getType().getKind(), constExp);
		int valToInsert = -1;

		if (value instanceof NumConstVal) {
			if (currentType.getType().getKind() != Struct.Int) {
				report_error("Const declaration is not correct \n", null);
				try {
					fileOut.write("Const declaration is not correct \n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			valToInsert = (((NumConstVal) value).getNumConst()).getNumberValue();
		} else if (value instanceof CharConstVal) {
			if (currentType.getType().getKind() != Struct.Char) {
				report_error("Const declaration is not correct \n", null);
				try {
					fileOut.write("Const declaration is not correct \n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			valToInsert = (((CharConstVal) value).getCharConst()).getCharacterValue();
		} else if (value instanceof BoolConstVal) {
			if (currentType.getType().getKind() != Struct.Bool) {
				report_error("Const declaration is not correct \n", null);
				try {
					fileOut.write("Const declaration is not correct \n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			valToInsert = (((BoolConstVal) value).getBoolConst()).getBooleanValue() ? 1 : 0;
		} else {
			report_error("Const declaration is not correct \n", null);
			try {
				fileOut.write("Const declaration is not correct \n".getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		Obj o = Tab.insert(Obj.Con, constExp.getConstName(), currentType.getType());

		o.setAdr(valToInsert);
		o.setLevel(0);
		constExp.obj = o;

		report_info(
				"ConstExpr: " + constExp.getConstName() + " visited(type is: "
						+ PrintTypeStruct[currentType.getType().getKind()] + ", value is: " + valToInsert + ")",
				constExp);
	}

	public void visit(ConstDeclaration constDeclaration) {
		currentType = Tab.noObj;
		report_info("ConstDeclaration visited", constDeclaration);
	}

	// TYPE
	// *******************************************************************************************************
	public void visit(Type type) {
		Obj typeObj = Tab.find(type.getTypeName());
		report_info("Type: " + type.getTypeName() + " visited", type);
		if (typeObj == Tab.noObj) {
			String text = "Type: " + type.getTypeName() + " is not in Symbol table \n";
			report_error(text, null);
			type.struct = Tab.noType;
			currentType = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if (Obj.Type != typeObj.getKind()) {
			String text = "Name: " + type.getTypeName() + " is not a Type \n";
			report_error("Name: " + type.getTypeName() + " is not a Type \n", null);
			type.struct = Tab.noType;
			currentType = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		currentType = typeObj;
		type.struct = typeObj.getType();

	}

	// METHOD
	// *******************************************************************************************************

	public void visit(MethodVoid methodVoid) {
		if (currLevel == 0)
			currLevel = 1;
		currentMethod = Tab.insert(Obj.Meth, methodVoid.getMethodName(), currentType.getType());
		methodName = methodVoid.getMethodName();
		Tab.openScope();
		currentLevel = Levels.Method;
		methodVoid.obj = currentMethod;
		report_info("Method: " + currentMethod.getName() + " is visiting... ret type is: void", methodVoid);
	}

	public void visit(MethodRetType methodRetType) {
		if (currLevel == 0)
			currLevel = 1;
		currentMethod = Tab.insert(Obj.Meth, methodRetType.getMethodName(), currentType.getType());
		methodName = methodRetType.getMethodName();
		currentLevel = Levels.Method;
		Tab.openScope();
		methodRetType.obj = currentMethod;
		report_info("Method: " + currentMethod.getName() + " is visiting... ret type is: "
				+ PrintTypeStruct[currentType.getType().getKind()], methodRetType);
	}

	public void visit(MethodDeclr methodDeclr) {
		if (methodDeclr.getMethodBegin() instanceof MethodVoid) {
			MethodVoid metV = (MethodVoid) methodDeclr.getMethodBegin();
			String name = metV.getMethodName();
			if (name.equals("main")) {
				isThereMain = true;
			}
		} else {
			MethodRetType metR = (MethodRetType) methodDeclr.getMethodBegin();
			String name = metR.getMethodName();
			if (name.equals("main")) {
				String text = "ERROR: main method has to be void type \n";
				report_error(text, null);
				try {
					fileOut.write(text.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		currentMethod.setLevel(formParamCnt);
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		report_info("MethodDecl: " + methodName + " visited. (formParamCnt=" + formParamCnt + ")", methodDeclr);
		formParamCnt = 0;
		methodName = "";
		currentMethod = Tab.noObj;
		report_info("CLEARED, methodName=" + methodName + " , formParamCnt=" + formParamCnt, methodDeclr);

	}

	public void visit(FormParams formParams) {
		formParamCnt++;
		if (Tab.find(formParams.getFormParamName().getFormParamName()) != Tab.noObj) {
			String text = "Formal parametar: " + formParams.getFormParamName().getFormParamName()
					+ " has already declared \n";
			report_error(text, null);
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		Tab.insert(Obj.Var, formParams.getFormParamName().getFormParamName(), currentType.getType());
		report_info("Method: " + methodName + " has " + formParamCnt + " formal params for now(name: "
				+ formParams.getFormParamName().getFormParamName() + " added)", formParams);
	}

	public void visit(FormParamArr formParamArr) {
		formParamCnt++;
		if (Tab.find(formParamArr.getFormParamName().getFormParamName()) != Tab.noObj) {
			String text = "Formal parametar: " + formParamArr.getFormParamName().getFormParamName()
					+ " has already declared \n";
			report_error(text, null);
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		Struct typeStruct = new Struct(Struct.Array, currentType.getType());
		Tab.insert(Obj.Var, formParamArr.getFormParamName().getFormParamName(), typeStruct);
		report_info("Method: " + methodName + " has " + formParamCnt + " formal params for now(name: "
				+ formParamArr.getFormParamName().getFormParamName() + " added)", formParamArr);
	}

	public void visit(OptArg optArg) {
		ConstVal value = optArg.getConstVal();
		int valToInsert;
		if (value instanceof NumConstVal) {
			if (currentType.getType().getKind() != Struct.Int) {
				report_error("Const declaration is not correct \n", null);
				try {
					fileOut.write("Const declaration is not correct \n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			valToInsert = (((NumConstVal) value).getNumConst()).getNumberValue();
		} else if (value instanceof CharConstVal) {
			if (currentType.getType().getKind() != Struct.Char) {
				try {
					fileOut.write("Const declaration is not correct \n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				report_error("Const declaration is not correct \n", null);
				return;
			}
			valToInsert = (((CharConstVal) value).getCharConst()).getCharacterValue();
		} else if (value instanceof BoolConstVal) {
			if (currentType.getType().getKind() != Struct.Bool) {
				try {
					fileOut.write("Const declaration is not correct \n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				report_error("Const declaration is not correct \n", null);
				return;
			}
			valToInsert = (((BoolConstVal) value).getBoolConst()).getBooleanValue() ? 1 : 0;
		}
		formParamCnt++;
		if (Tab.find(optArg.getOptArgName()) != Tab.noObj) {
			String text = "OptArg: " + optArg.getOptArgName() + " has already declared \n";
			report_error(text, null);
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		Obj optArgObj = Tab.insert(Obj.Var, optArg.getOptArgName(), currentType.getType());
		report_info("OptArg: " + optArg.getOptArgName() + " declared, method: " + methodName + " has arguments: "
				+ formParamCnt, optArg);
	}

	// DESIGNATOR
	// *******************************************************************************************************

	public void visit(DesignatorIdentOnly designatorIdentOnly) {
		designatorIdentOnly.obj = Tab.find(designatorIdentOnly.getDesignatorName());
	}

	public void visit(DesignatorArrayExpr designatorArrayExpr) {
		Obj desObj = designatorArrayExpr.getDesignator().obj;
		if (desObj.getType().getKind() != Struct.Array) {
			String text = "ERROR: Designator name: " + desObj.getName() + " is not array type \n";
			report_error(text, null);
			designatorArrayExpr.obj = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if (!designatorArrayExpr.getExpr().struct.equals(Tab.intType)) {
			String text = "ERROR: Expression which is part of DesignatorArrayExpr has to be int type \n";
			report_error(text, null);
			designatorArrayExpr.obj = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		designatorArrayExpr.obj = new Obj(Obj.Elem, desObj.getName(), desObj.getType().getElemType());
		report_info("DesignatorArrayExpr visited. Array name is: " + desObj.getName(), designatorArrayExpr);
	}

	public void visit(DesignatorParamsAssignopExpr designatorParamsAssignopExpr) {
		Obj desObj = designatorParamsAssignopExpr.getDesignator().obj;

		int desKind = desObj.getKind();
		if (desObj == Tab.noObj) {
			return;
		}
		// desObj.getKind();
		if (desKind != Obj.Fld && desKind != Obj.Elem && desKind != Obj.Var) {
			String text = "ERROR: Designator name: " + desObj.getName()
					+ " has to be kind Fld, Elem or Var.(value assignment is impossible) \n";
			report_error(text, null);
			designatorParamsAssignopExpr.getDesignator().obj = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		report_info("Value assignment is processing (designator name: " + desObj.getName() + ", type: "
				+ PrintTypeStruct[desObj.getType().getKind()] + "; expr : " + designatorParamsAssignopExpr.getExpr()
		// + ", expr.struct: " +
		// PrintTypeStruct[designatorParamsAssignopExpr.getExpr().struct.getKind()] +
		// ")"
				, null);
		/*
		 * if (!desObj.getType().compatibleWith(designatorParamsAssignopExpr.getExpr().
		 * struct)) {
		 * report_error("ERROR: value assignment is impossible. Incompatible types. (designator name: "
		 * + desObj.getName() + ", type: " + PrintTypeStruct[desObj.getType().getKind()]
		 * + "; expr type: " + designatorParamsAssignopExpr.getExpr().struct.getKind() +
		 * ")", null); designatorParamsAssignopExpr.getDesignator().obj = Tab.noObj;
		 * return; }
		 */
		if (desObj.getType().getKind() == Struct.Array
				&& designatorParamsAssignopExpr.getExpr().struct.getKind() == Struct.Array && !desObj.getType()
						.getElemType().compatibleWith(designatorParamsAssignopExpr.getExpr().struct.getElemType())) {
			String text = "ERROR: value assignment is impossible. Incompatible types. (designator name: "
					+ desObj.getName() + ") \n";
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			report_error(text, null);
			designatorParamsAssignopExpr.getDesignator().obj = Tab.noObj;
			return;
		}
		report_info("DesignatorParamsAssignopExpr visited. Value assignment is processing...",
				designatorParamsAssignopExpr);
	}

	public void visit(DesignatorParamsInc designatorParamsInc) {
		Obj desObj = designatorParamsInc.getDesignator().obj;
		if (desObj == Tab.noObj) {
			return;
		}
		int desKind = desObj.getKind();
		if (desKind != Obj.Fld && desKind != Obj.Elem && desKind != Obj.Var) {
			String text = "ERROR: Designator name: " + desObj.getName()
					+ " has to be kind Fld, Elem or Var.(inc operation is impossible) \n";
			report_error(text, null);
			designatorParamsInc.getDesignator().obj = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if (desObj.getType().getKind() != Struct.Int) {
			String text = "ERROR: Designator name: " + desObj.getName()
					+ " has to be int type.(inc operation is impossible) \n";
			report_error(text, null);
			designatorParamsInc.getDesignator().obj = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		report_info("DesignatorParamsInc visited. Inc operation is processing...", designatorParamsInc);
	}

	public void visit(DesignatorParamsDec designatorParamsDec) {
		Obj desObj = designatorParamsDec.getDesignator().obj;
		if (desObj == Tab.noObj) {
			return;
		}
		int desKind = desObj.getKind();
		if (desKind != Obj.Fld && desKind != Obj.Elem && desKind != Obj.Var) {
			String text = "ERROR: Designator name: " + desObj.getName()
					+ " has to be kind Fld, Elem or Var.(dec operation is impossible) \n";
			report_error(text, null);
			designatorParamsDec.getDesignator().obj = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if (desObj.getType().getKind() != Struct.Int) {
			String text = "ERROR: Designator name: " + desObj.getName()
					+ " has to be int type.(dec operation is impossible) \n";
			report_error(text, null);
			designatorParamsDec.getDesignator().obj = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		report_info("DesignatorParamsDec visited. Dec operation is processing...", designatorParamsDec);
	}

	public void visit(ReadStatement readStatement) {
		Obj readObj = readStatement.getDesignator().obj;
		if (readObj == Tab.noObj) {
			return;
		}
		int readKind = readObj.getKind();
		if (readKind != Obj.Fld && readKind != Obj.Elem && readKind != Obj.Var) {
			String text = "ERROR: SingleStatement name: " + readObj.getName()
					+ " has to be kind Fld, Elem or Var.(read operation is impossible) \n";
			report_error(text, null);
			readStatement.getDesignator().obj = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if (readObj.getType().getKind() != Struct.Int && readObj.getType().getKind() != Struct.Char
				&& readObj.getType().getKind() != Struct.Bool) {
			String text = "ERROR: SingleStatement name: " + readObj.getName()
					+ " has to be int, char or bool type.(read operation operation is impossible) \n";
			report_error(text, null);
			readStatement.getDesignator().obj = Tab.noObj;
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		report_info("ReadStatement visited. Read operation is processing...", readStatement);
	}

	public void visit(PrintExprStatement printExprStatement) {
		Struct printStruct = printExprStatement.getExpr().struct;
		if (!printStruct.equals(Tab.intType) && !printStruct.equals(Tab.charType) && !printStruct.equals(boolStruct)) {
			String text = "ERROR: Expression hich is part of PrintStatement has to be int, char or bool type.(PrintStatement is impossible) \n";
			report_error(text, null);
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		printCnt++;
		report_info("PrintStatement visited. Print operation is processing...", printExprStatement);
	}

	public void visit(PrintExprNumStatement printExprStatement) {
		Struct printStruct = printExprStatement.getExpr().struct;
		if (!printStruct.equals(Tab.intType) && !printStruct.equals(Tab.charType) && !printStruct.equals(boolStruct)) {
			String text = "ERROR: Expression hich is part of PrintStatement has to be int, char or bool type.(PrintStatement is impossible) \n";
			report_error(text, null);
			try {
				fileOut.write(text.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		printCnt++;
		report_info("PrintStatement visited. Print operation is processing...", printExprStatement);
	}

	// NUM CONST, CHAR CONNST, BOOL CONST
	// ***************************************************************************************
	public void visit(NumConst numConst) {
		currentType = new Obj(Obj.Var, "", Tab.intType);
	}

	public void visit(CharConst charConst) {
		currentType = new Obj(Obj.Var, "", Tab.charType);
	}

	public void visit(BoolConst numConst) {
		currentType = new Obj(Obj.Var, "", boolStruct);
	}

	// TERM
	// ***************************************************************************************

	public void visit(Term term) {
		if (term.getListOfMulopFactors() instanceof ListMulopFactors && !term.getFactor().struct.equals(Tab.intType)) {
			report_info("Term type: " + PrintTypeStruct[term.getFactor().struct.getKind()], term);
			report_error("ERROR: Factor has to be int type in mulop expressions \n", null);
			try {
				fileOut.write("ERROR: Factor has to be int type in mulop expressions \n".getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			term.struct = Tab.noType;
			return;
		}
		term.struct = term.getFactor().struct;
		// System.out.println("Term is visiting");
		// System.out.println("term.struct: " +
		// PrintTypeStruct[term.getFactor().struct.getKind()]);
	}

	public void visit(Factor factor) {
		factor.struct = factor.getFactorWrapper().struct;
		// System.out.println("Factor is visiting");
		// System.out.println("factor.struct: " +
		// PrintTypeStruct[factor.getFactorWrapper().struct.getKind()]);
	}

	public void visit(FactorDesign factorDesign) {
		factorDesign.struct = factorDesign.getDesignator().obj.getType();
		// System.out.println("FactorDesign is visiting");
		// System.out.println("factorDesign.struct: " +
		// PrintTypeStruct[factorDesign.struct.getKind()]);
	}

	public void visit(FactorNum factorNum) {
		factorNum.struct = Tab.intType;
		// System.out.println("FactorNum is visiting");
		// System.out.println("factorNum.struct: " +
		// PrintTypeStruct[factorNum.struct.getKind()]);
	}

	public void visit(FactorChar factorChar) {
		factorChar.struct = Tab.charType;
		// System.out.println("FactorChar is visiting");
		// System.out.println("factorChar.struct: " +
		// PrintTypeStruct[factorChar.struct.getKind()]);
	}

	public void visit(FactorBool factorBool) {
		factorBool.struct = boolStruct;
		// System.out.println("FactorBool is visiting");
		// System.out.println("factorBool.struct: " +
		// PrintTypeStruct[factorBool.struct.getKind()]);
	}

	// ovde
	public void visit(FactorExpr factorExpr) {
		factorExpr.struct = factorExpr.getExpr().struct;
		// System.out.println("FactorExpr is visiting");
		// System.out.println("factorExpr.struct: " +
		// PrintTypeStruct[factorExpr.getExpr().struct.getKind()]);
	}

	// ovde
	public void visit(FactorNewTypeExpr factorNewTypeExpr) {
		factorNewTypeExpr.struct = new Struct(Struct.Array, factorNewTypeExpr.getType().struct);
		if (!factorNewTypeExpr.getExpr().struct.equals(Tab.intType)) {
			report_error("ERROR: Expression inside brackets has to be int type \n", null);
			factorNewTypeExpr.struct = Tab.noType;
			try {
				fileOut.write("ERROR: Expression inside brackets has to be int type \n".getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		// System.out.println("FactorNewTypeExpr is visiting");
		// System.out.println("factorNewTypeExpr.struct: " +
		// PrintTypeStruct[factorNewTypeExpr.struct.getKind()]);
	}

	// EXPRESSION
	// ***************************************************************************************

	public void visit(ExprClass expr) {
		if (expr.getExprIsNull() instanceof ExprExprIsNullClass) {
			if (!expr.getExprSingle().struct.equals(Tab.intType)) {
				report_error("ERROR: Expression with operator ?? has to be int type \n", null);
				expr.struct = Tab.noType;
				try {
					fileOut.write("ERROR: Expression with operator ?? has to be int type \n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
		// System.out.println("ExprClass is visiting");
		expr.struct = expr.getExprSingle().struct;
		// System.out.println("expr.struct: " +
		// PrintTypeStruct[expr.getExprSingle().struct.getKind()]);
	}

	public void visit(ExprExprIsNullClass expr) {
		if (!expr.getExpr().struct.equals(Tab.intType)) {
			report_error("ERROR: Expression with operator ?? has to be int type \n", null);
			expr.getExpr().struct = Tab.noType;
			try {
				fileOut.write("ERROR: Expression with operator ?? has to be int type \n".getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		// System.out.println("ExprExprIsNullClass is visiting");
	}

	public void visit(ListAddopTerms listAddopTerms) {
		if (listAddopTerms.getTerm().struct != null && listAddopTerms.getTerm().struct != Tab.noType) {
			if (!listAddopTerms.getTerm().struct.equals(Tab.intType)) {
				report_error("ERROR: Expression with operators + or - has to be int type \n", null);
				try {
					fileOut.write("ERROR: Expression with operators + or - has to be int type \n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
		// System.out.println("ListAddopTerms is visiting");
	}

	public void visit(ExprPositive exprPositive) {
		if (exprPositive.getListOfAddopTerms() instanceof ListAddopTerms) {
			if (!exprPositive.getTerm().struct.equals(Tab.intType)) {
				report_error("ERROR: Term in + or - operations has to be int \n", null);
				exprPositive.struct = Tab.noType;
				try {
					fileOut.write("ERROR: Term in + or - operations has to be int \n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
		// System.out.println("ExprPositive is visiting");
		exprPositive.struct = exprPositive.getTerm().struct;
		// System.out.println("exprPositive.struct: " +
		// PrintTypeStruct[exprPositive.getTerm().struct.getKind()]);
	}

	public void visit(ExprNegative exprNegative) {
		if (exprNegative.getListOfAddopTerms() instanceof ListAddopTerms) {
			if (!exprNegative.getTerm().struct.equals(Tab.intType)) {
				report_error("ERROR: Term in + or - operations has to be int \n", null);
				exprNegative.struct = Tab.noType;
				try {
					fileOut.write("ERROR: Term in + or - operations has to be int \n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
		// System.out.println("ExprNegative is visiting");
		exprNegative.struct = exprNegative.getTerm().struct;
	}
	
	
	
	
	
	
	
	
	/*
	 * public void visit(DesignatorReverse rev) { Obj desObj =
	 * rev.getDesignator().obj;
	 * 
	 * int desKind = desObj.getKind(); if (desObj == Tab.noObj) { return; } if
	 * (desKind != Obj.Fld && desKind != Obj.Elem && desKind != Obj.Var) { String
	 * text = "ERROR: Designator name: " + desObj.getName() +
	 * " has to be kind Fld, Elem or Var.(value assignment is impossible) \n";
	 * report_error(text, null); rev.getDesignator().obj = Tab.noObj; try {
	 * fileOut.write(text.getBytes()); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return; }
	 * report_info("Operation reverse is processing (designator name: " +
	 * desObj.getName() + ", type: " +
	 * PrintTypeStruct[desObj.getType().getKind()],rev);
	 * 
	 * if (desObj.getType().getKind() != Struct.Array) { String text =
	 * "ERROR: reverse is impossible. An array type has to be on the left side. (designator name: "
	 * + desObj.getName() + ") \n"; try { fileOut.write(text.getBytes()); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * report_error(text, null); rev.getDesignator().obj = Tab.noObj; return; }
	 * report_info("DesignatorReverse visited. Reverse is processing...", rev); }
	 * 
	 * public void visit(DesignatorParamsIncInc designatorParamsInc) { Obj desObj =
	 * designatorParamsInc.getDesignator().obj; if (desObj == Tab.noObj) { return; }
	 * int desKind = desObj.getKind(); if (desKind != Obj.Fld && desKind != Obj.Elem
	 * && desKind != Obj.Var) { String text = "ERROR: Designator name: " +
	 * desObj.getName() +
	 * " has to be kind Fld, Elem or Var.(inc operation is impossible) \n";
	 * report_error(text, null); designatorParamsInc.getDesignator().obj =
	 * Tab.noObj; try { fileOut.write(text.getBytes()); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } return; } if
	 * (desObj.getType().getKind() != Struct.Int) { String text =
	 * "ERROR: Designator name: " + desObj.getName() +
	 * " has to be int type.(inc operation is impossible) \n"; report_error(text,
	 * null); designatorParamsInc.getDesignator().obj = Tab.noObj; try {
	 * fileOut.write(text.getBytes()); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return; }
	 * report_info("DesignatorParamsIncInc visited. IncInc operation is processing..."
	 * , designatorParamsInc);
	 * 
	 * }
	 * 
	 * public void visit(FactorMaxArray des) { // samo proveris da li ovaj des niz
	 * if(des.getDesignator().obj.getKind()!=Obj.Var &&
	 * des.getDesignator().obj.getKind()!=Obj.Fld) {
	 * report_error("Max se trazi samo za niz!", null); }
	 * if(des.getDesignator().obj.getType().getKind()!=Struct.Array) {
	 * report_error("Max se trazi samo za niz!", null); } }
	 */

}
