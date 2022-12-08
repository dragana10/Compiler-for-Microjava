// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class DoStatement extends MatchedStatement {

    private DoPart DoPart;
    private SingleStatement SingleStatement;
    private WhilePart WhilePart;
    private Condition Condition;

    public DoStatement (DoPart DoPart, SingleStatement SingleStatement, WhilePart WhilePart, Condition Condition) {
        this.DoPart=DoPart;
        if(DoPart!=null) DoPart.setParent(this);
        this.SingleStatement=SingleStatement;
        if(SingleStatement!=null) SingleStatement.setParent(this);
        this.WhilePart=WhilePart;
        if(WhilePart!=null) WhilePart.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public DoPart getDoPart() {
        return DoPart;
    }

    public void setDoPart(DoPart DoPart) {
        this.DoPart=DoPart;
    }

    public SingleStatement getSingleStatement() {
        return SingleStatement;
    }

    public void setSingleStatement(SingleStatement SingleStatement) {
        this.SingleStatement=SingleStatement;
    }

    public WhilePart getWhilePart() {
        return WhilePart;
    }

    public void setWhilePart(WhilePart WhilePart) {
        this.WhilePart=WhilePart;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DoPart!=null) DoPart.accept(visitor);
        if(SingleStatement!=null) SingleStatement.accept(visitor);
        if(WhilePart!=null) WhilePart.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoPart!=null) DoPart.traverseTopDown(visitor);
        if(SingleStatement!=null) SingleStatement.traverseTopDown(visitor);
        if(WhilePart!=null) WhilePart.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoPart!=null) DoPart.traverseBottomUp(visitor);
        if(SingleStatement!=null) SingleStatement.traverseBottomUp(visitor);
        if(WhilePart!=null) WhilePart.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoStatement(\n");

        if(DoPart!=null)
            buffer.append(DoPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleStatement!=null)
            buffer.append(SingleStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(WhilePart!=null)
            buffer.append(WhilePart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoStatement]");
        return buffer.toString();
    }
}
