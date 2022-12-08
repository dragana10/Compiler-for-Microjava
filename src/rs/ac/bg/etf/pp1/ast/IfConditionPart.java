// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class IfConditionPart implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private IfPart IfPart;
    private Condition Condition;

    public IfConditionPart (IfPart IfPart, Condition Condition) {
        this.IfPart=IfPart;
        if(IfPart!=null) IfPart.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public IfPart getIfPart() {
        return IfPart;
    }

    public void setIfPart(IfPart IfPart) {
        this.IfPart=IfPart;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
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
        if(IfPart!=null) IfPart.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfPart!=null) IfPart.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfPart!=null) IfPart.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfConditionPart(\n");

        if(IfPart!=null)
            buffer.append(IfPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfConditionPart]");
        return buffer.toString();
    }
}
