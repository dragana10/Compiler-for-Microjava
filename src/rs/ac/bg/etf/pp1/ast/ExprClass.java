// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ExprClass extends Expr {

    private ExprSingle ExprSingle;
    private ExprIsNull ExprIsNull;

    public ExprClass (ExprSingle ExprSingle, ExprIsNull ExprIsNull) {
        this.ExprSingle=ExprSingle;
        if(ExprSingle!=null) ExprSingle.setParent(this);
        this.ExprIsNull=ExprIsNull;
        if(ExprIsNull!=null) ExprIsNull.setParent(this);
    }

    public ExprSingle getExprSingle() {
        return ExprSingle;
    }

    public void setExprSingle(ExprSingle ExprSingle) {
        this.ExprSingle=ExprSingle;
    }

    public ExprIsNull getExprIsNull() {
        return ExprIsNull;
    }

    public void setExprIsNull(ExprIsNull ExprIsNull) {
        this.ExprIsNull=ExprIsNull;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprSingle!=null) ExprSingle.accept(visitor);
        if(ExprIsNull!=null) ExprIsNull.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprSingle!=null) ExprSingle.traverseTopDown(visitor);
        if(ExprIsNull!=null) ExprIsNull.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprSingle!=null) ExprSingle.traverseBottomUp(visitor);
        if(ExprIsNull!=null) ExprIsNull.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprClass(\n");

        if(ExprSingle!=null)
            buffer.append(ExprSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprIsNull!=null)
            buffer.append(ExprIsNull.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprClass]");
        return buffer.toString();
    }
}
