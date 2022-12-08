// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ClassBodyWithMethodsOnly extends ClassBodyWithoutConstructorPart {

    private MethodDecl MethodDecl;
    private ListOfMethodDecls ListOfMethodDecls;

    public ClassBodyWithMethodsOnly (MethodDecl MethodDecl, ListOfMethodDecls ListOfMethodDecls) {
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
        this.ListOfMethodDecls=ListOfMethodDecls;
        if(ListOfMethodDecls!=null) ListOfMethodDecls.setParent(this);
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public ListOfMethodDecls getListOfMethodDecls() {
        return ListOfMethodDecls;
    }

    public void setListOfMethodDecls(ListOfMethodDecls ListOfMethodDecls) {
        this.ListOfMethodDecls=ListOfMethodDecls;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDecl!=null) MethodDecl.accept(visitor);
        if(ListOfMethodDecls!=null) ListOfMethodDecls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
        if(ListOfMethodDecls!=null) ListOfMethodDecls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        if(ListOfMethodDecls!=null) ListOfMethodDecls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBodyWithMethodsOnly(\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfMethodDecls!=null)
            buffer.append(ListOfMethodDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassBodyWithMethodsOnly]");
        return buffer.toString();
    }
}
