// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class Factor implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private FactorWrapper FactorWrapper;

    public Factor (FactorWrapper FactorWrapper) {
        this.FactorWrapper=FactorWrapper;
        if(FactorWrapper!=null) FactorWrapper.setParent(this);
    }

    public FactorWrapper getFactorWrapper() {
        return FactorWrapper;
    }

    public void setFactorWrapper(FactorWrapper FactorWrapper) {
        this.FactorWrapper=FactorWrapper;
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
        if(FactorWrapper!=null) FactorWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorWrapper!=null) FactorWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorWrapper!=null) FactorWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factor(\n");

        if(FactorWrapper!=null)
            buffer.append(FactorWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factor]");
        return buffer.toString();
    }
}
