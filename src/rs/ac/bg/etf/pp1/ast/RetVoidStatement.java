// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class RetVoidStatement extends MatchedStatement {

    private ReturnPart ReturnPart;

    public RetVoidStatement (ReturnPart ReturnPart) {
        this.ReturnPart=ReturnPart;
        if(ReturnPart!=null) ReturnPart.setParent(this);
    }

    public ReturnPart getReturnPart() {
        return ReturnPart;
    }

    public void setReturnPart(ReturnPart ReturnPart) {
        this.ReturnPart=ReturnPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnPart!=null) ReturnPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnPart!=null) ReturnPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnPart!=null) ReturnPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RetVoidStatement(\n");

        if(ReturnPart!=null)
            buffer.append(ReturnPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RetVoidStatement]");
        return buffer.toString();
    }
}
