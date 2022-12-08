// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class RetExprStatement extends MatchedStatement {

    private ReturnPart ReturnPart;
    private Expr Expr;

    public RetExprStatement (ReturnPart ReturnPart, Expr Expr) {
        this.ReturnPart=ReturnPart;
        if(ReturnPart!=null) ReturnPart.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ReturnPart getReturnPart() {
        return ReturnPart;
    }

    public void setReturnPart(ReturnPart ReturnPart) {
        this.ReturnPart=ReturnPart;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnPart!=null) ReturnPart.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnPart!=null) ReturnPart.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnPart!=null) ReturnPart.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RetExprStatement(\n");

        if(ReturnPart!=null)
            buffer.append(ReturnPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RetExprStatement]");
        return buffer.toString();
    }
}
