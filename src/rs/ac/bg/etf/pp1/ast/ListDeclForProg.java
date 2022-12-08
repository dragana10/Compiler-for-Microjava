// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ListDeclForProg extends ListOfDeclForProg {

    private ListOfDeclForProg ListOfDeclForProg;
    private DeclForProg DeclForProg;

    public ListDeclForProg (ListOfDeclForProg ListOfDeclForProg, DeclForProg DeclForProg) {
        this.ListOfDeclForProg=ListOfDeclForProg;
        if(ListOfDeclForProg!=null) ListOfDeclForProg.setParent(this);
        this.DeclForProg=DeclForProg;
        if(DeclForProg!=null) DeclForProg.setParent(this);
    }

    public ListOfDeclForProg getListOfDeclForProg() {
        return ListOfDeclForProg;
    }

    public void setListOfDeclForProg(ListOfDeclForProg ListOfDeclForProg) {
        this.ListOfDeclForProg=ListOfDeclForProg;
    }

    public DeclForProg getDeclForProg() {
        return DeclForProg;
    }

    public void setDeclForProg(DeclForProg DeclForProg) {
        this.DeclForProg=DeclForProg;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfDeclForProg!=null) ListOfDeclForProg.accept(visitor);
        if(DeclForProg!=null) DeclForProg.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfDeclForProg!=null) ListOfDeclForProg.traverseTopDown(visitor);
        if(DeclForProg!=null) DeclForProg.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfDeclForProg!=null) ListOfDeclForProg.traverseBottomUp(visitor);
        if(DeclForProg!=null) DeclForProg.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListDeclForProg(\n");

        if(ListOfDeclForProg!=null)
            buffer.append(ListOfDeclForProg.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclForProg!=null)
            buffer.append(DeclForProg.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListDeclForProg]");
        return buffer.toString();
    }
}
