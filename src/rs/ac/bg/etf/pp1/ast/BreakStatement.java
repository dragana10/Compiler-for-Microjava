// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class BreakStatement extends MatchedStatement {

    private BreakPart BreakPart;

    public BreakStatement (BreakPart BreakPart) {
        this.BreakPart=BreakPart;
        if(BreakPart!=null) BreakPart.setParent(this);
    }

    public BreakPart getBreakPart() {
        return BreakPart;
    }

    public void setBreakPart(BreakPart BreakPart) {
        this.BreakPart=BreakPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BreakPart!=null) BreakPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BreakPart!=null) BreakPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BreakPart!=null) BreakPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BreakStatement(\n");

        if(BreakPart!=null)
            buffer.append(BreakPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BreakStatement]");
        return buffer.toString();
    }
}
