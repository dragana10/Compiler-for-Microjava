// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ConstructorDeclr extends ConstructorDecl {

    private String I1;
    private MulVarDecls MulVarDecls;
    private Statements Statements;

    public ConstructorDeclr (String I1, MulVarDecls MulVarDecls, Statements Statements) {
        this.I1=I1;
        this.MulVarDecls=MulVarDecls;
        if(MulVarDecls!=null) MulVarDecls.setParent(this);
        this.Statements=Statements;
        if(Statements!=null) Statements.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
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
        if(MulVarDecls!=null) MulVarDecls.accept(visitor);
        if(Statements!=null) Statements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulVarDecls!=null) MulVarDecls.traverseTopDown(visitor);
        if(Statements!=null) Statements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulVarDecls!=null) MulVarDecls.traverseBottomUp(visitor);
        if(Statements!=null) Statements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorDeclr(\n");

        buffer.append(" "+tab+I1);
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
        buffer.append(") [ConstructorDeclr]");
        return buffer.toString();
    }
}
