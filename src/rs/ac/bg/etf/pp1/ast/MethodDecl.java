// generated with ast extension for cup
// version 0.8
// 7/1/2022 3:1:25


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodReturnType MethodReturnType;
    private MethodFormPars MethodFormPars;
    private MultipleVarDecl MultipleVarDecl;
    private Statements Statements;

    public MethodDecl (MethodReturnType MethodReturnType, MethodFormPars MethodFormPars, MultipleVarDecl MultipleVarDecl, Statements Statements) {
        this.MethodReturnType=MethodReturnType;
        if(MethodReturnType!=null) MethodReturnType.setParent(this);
        this.MethodFormPars=MethodFormPars;
        if(MethodFormPars!=null) MethodFormPars.setParent(this);
        this.MultipleVarDecl=MultipleVarDecl;
        if(MultipleVarDecl!=null) MultipleVarDecl.setParent(this);
        this.Statements=Statements;
        if(Statements!=null) Statements.setParent(this);
    }

    public MethodReturnType getMethodReturnType() {
        return MethodReturnType;
    }

    public void setMethodReturnType(MethodReturnType MethodReturnType) {
        this.MethodReturnType=MethodReturnType;
    }

    public MethodFormPars getMethodFormPars() {
        return MethodFormPars;
    }

    public void setMethodFormPars(MethodFormPars MethodFormPars) {
        this.MethodFormPars=MethodFormPars;
    }

    public MultipleVarDecl getMultipleVarDecl() {
        return MultipleVarDecl;
    }

    public void setMultipleVarDecl(MultipleVarDecl MultipleVarDecl) {
        this.MultipleVarDecl=MultipleVarDecl;
    }

    public Statements getStatements() {
        return Statements;
    }

    public void setStatements(Statements Statements) {
        this.Statements=Statements;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodReturnType!=null) MethodReturnType.accept(visitor);
        if(MethodFormPars!=null) MethodFormPars.accept(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.accept(visitor);
        if(Statements!=null) Statements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodReturnType!=null) MethodReturnType.traverseTopDown(visitor);
        if(MethodFormPars!=null) MethodFormPars.traverseTopDown(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.traverseTopDown(visitor);
        if(Statements!=null) Statements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodReturnType!=null) MethodReturnType.traverseBottomUp(visitor);
        if(MethodFormPars!=null) MethodFormPars.traverseBottomUp(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.traverseBottomUp(visitor);
        if(Statements!=null) Statements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodReturnType!=null)
            buffer.append(MethodReturnType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodFormPars!=null)
            buffer.append(MethodFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MultipleVarDecl!=null)
            buffer.append(MultipleVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statements!=null)
            buffer.append(Statements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
