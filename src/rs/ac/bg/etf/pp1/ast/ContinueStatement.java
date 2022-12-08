// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ContinueStatement extends MatchedStatement {

    private ContinuePart ContinuePart;

    public ContinueStatement (ContinuePart ContinuePart) {
        this.ContinuePart=ContinuePart;
        if(ContinuePart!=null) ContinuePart.setParent(this);
    }

    public ContinuePart getContinuePart() {
        return ContinuePart;
    }

    public void setContinuePart(ContinuePart ContinuePart) {
        this.ContinuePart=ContinuePart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ContinuePart!=null) ContinuePart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ContinuePart!=null) ContinuePart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ContinuePart!=null) ContinuePart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ContinueStatement(\n");

        if(ContinuePart!=null)
            buffer.append(ContinuePart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ContinueStatement]");
        return buffer.toString();
    }
}
