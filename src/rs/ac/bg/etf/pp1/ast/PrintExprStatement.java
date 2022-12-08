// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class PrintExprStatement extends MatchedStatement {

    private PrintPart PrintPart;
    private Expr Expr;

    public PrintExprStatement (PrintPart PrintPart, Expr Expr) {
        this.PrintPart=PrintPart;
        if(PrintPart!=null) PrintPart.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public PrintPart getPrintPart() {
        return PrintPart;
    }

    public void setPrintPart(PrintPart PrintPart) {
        this.PrintPart=PrintPart;
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
        if(PrintPart!=null) PrintPart.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PrintPart!=null) PrintPart.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PrintPart!=null) PrintPart.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintExprStatement(\n");

        if(PrintPart!=null)
            buffer.append(PrintPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintExprStatement]");
        return buffer.toString();
    }
}
