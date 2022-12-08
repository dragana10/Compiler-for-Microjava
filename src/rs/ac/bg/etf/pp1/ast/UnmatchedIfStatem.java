// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedIfStatem extends UnmatchedStatement {

    private IfConditionPart IfConditionPart;
    private SingleStatement SingleStatement;

    public UnmatchedIfStatem (IfConditionPart IfConditionPart, SingleStatement SingleStatement) {
        this.IfConditionPart=IfConditionPart;
        if(IfConditionPart!=null) IfConditionPart.setParent(this);
        this.SingleStatement=SingleStatement;
        if(SingleStatement!=null) SingleStatement.setParent(this);
    }

    public IfConditionPart getIfConditionPart() {
        return IfConditionPart;
    }

    public void setIfConditionPart(IfConditionPart IfConditionPart) {
        this.IfConditionPart=IfConditionPart;
    }

    public SingleStatement getSingleStatement() {
        return SingleStatement;
    }

    public void setSingleStatement(SingleStatement SingleStatement) {
        this.SingleStatement=SingleStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfConditionPart!=null) IfConditionPart.accept(visitor);
        if(SingleStatement!=null) SingleStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfConditionPart!=null) IfConditionPart.traverseTopDown(visitor);
        if(SingleStatement!=null) SingleStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfConditionPart!=null) IfConditionPart.traverseBottomUp(visitor);
        if(SingleStatement!=null) SingleStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedIfStatem(\n");

        if(IfConditionPart!=null)
            buffer.append(IfConditionPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleStatement!=null)
            buffer.append(SingleStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedIfStatem]");
        return buffer.toString();
    }
}
