// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ListMethodDecls extends ListOfMethodDecls {

    private ListOfMethodDecls ListOfMethodDecls;
    private MethodDecl MethodDecl;

    public ListMethodDecls (ListOfMethodDecls ListOfMethodDecls, MethodDecl MethodDecl) {
        this.ListOfMethodDecls=ListOfMethodDecls;
        if(ListOfMethodDecls!=null) ListOfMethodDecls.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public ListOfMethodDecls getListOfMethodDecls() {
        return ListOfMethodDecls;
    }

    public void setListOfMethodDecls(ListOfMethodDecls ListOfMethodDecls) {
        this.ListOfMethodDecls=ListOfMethodDecls;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfMethodDecls!=null) ListOfMethodDecls.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfMethodDecls!=null) ListOfMethodDecls.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfMethodDecls!=null) ListOfMethodDecls.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListMethodDecls(\n");

        if(ListOfMethodDecls!=null)
            buffer.append(ListOfMethodDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListMethodDecls]");
        return buffer.toString();
    }
}
