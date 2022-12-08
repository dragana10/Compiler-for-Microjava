// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ExprExprIsNullClass extends ExprIsNull {

    private IsNull IsNull;
    private Expr Expr;

    public ExprExprIsNullClass (IsNull IsNull, Expr Expr) {
        this.IsNull=IsNull;
        if(IsNull!=null) IsNull.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public IsNull getIsNull() {
        return IsNull;
    }

    public void setIsNull(IsNull IsNull) {
        this.IsNull=IsNull;
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
        if(IsNull!=null) IsNull.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IsNull!=null) IsNull.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IsNull!=null) IsNull.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprExprIsNullClass(\n");

        if(IsNull!=null)
            buffer.append(IsNull.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprExprIsNullClass]");
        return buffer.toString();
    }
}
