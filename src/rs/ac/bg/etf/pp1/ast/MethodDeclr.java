// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclr extends MethodDecl {

    private MethodBegin MethodBegin;
    private MethodFormPars MethodFormPars;
    private MulVarDecls MulVarDecls;
    private Statements Statements;

    public MethodDeclr (MethodBegin MethodBegin, MethodFormPars MethodFormPars, MulVarDecls MulVarDecls, Statements Statements) {
        this.MethodBegin=MethodBegin;
        if(MethodBegin!=null) MethodBegin.setParent(this);
        this.MethodFormPars=MethodFormPars;
        if(MethodFormPars!=null) MethodFormPars.setParent(this);
        this.MulVarDecls=MulVarDecls;
        if(MulVarDecls!=null) MulVarDecls.setParent(this);
        this.Statements=Statements;
        if(Statements!=null) Statements.setParent(this);
    }

    public MethodBegin getMethodBegin() {
        return MethodBegin;
    }

    public void setMethodBegin(MethodBegin MethodBegin) {
        this.MethodBegin=MethodBegin;
    }

    public MethodFormPars getMethodFormPars() {
        return MethodFormPars;
    }

    public void setMethodFormPars(MethodFormPars MethodFormPars) {
        this.MethodFormPars=MethodFormPars;
    }

    public MulVarDecls getMulVarDecls() {
        return MulVarDecls;
    }

    public void setMulVarDecls(MulVarDecls MulVarDecls) {
        this.MulVarDecls=MulVarDecls;
    }

    public Statements getStatements() {
        return Statements;
    }

    public void setStatements(Statements Statements) {
        this.Statements=Statements;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodBegin!=null) MethodBegin.accept(visitor);
        if(MethodFormPars!=null) MethodFormPars.accept(visitor);
        if(MulVarDecls!=null) MulVarDecls.accept(visitor);
        if(Statements!=null) Statements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodBegin!=null) MethodBegin.traverseTopDown(visitor);
        if(MethodFormPars!=null) MethodFormPars.traverseTopDown(visitor);
        if(MulVarDecls!=null) MulVarDecls.traverseTopDown(visitor);
        if(Statements!=null) Statements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodBegin!=null) MethodBegin.traverseBottomUp(visitor);
        if(MethodFormPars!=null) MethodFormPars.traverseBottomUp(visitor);
        if(MulVarDecls!=null) MulVarDecls.traverseBottomUp(visitor);
        if(Statements!=null) Statements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclr(\n");

        if(MethodBegin!=null)
            buffer.append(MethodBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodFormPars!=null)
            buffer.append(MethodFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MulVarDecls!=null)
            buffer.append(MulVarDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statements!=null)
            buffer.append(Statements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclr]");
        return buffer.toString();
    }
}
