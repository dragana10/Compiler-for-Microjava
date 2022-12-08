// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ClassBodyWithConstructorAndMethods extends ClassBodyWithConstructorPart {

    private ConstructorDecl ConstructorDecl;
    private MethodDecl MethodDecl;
    private ListOfMethodDecls ListOfMethodDecls;

    public ClassBodyWithConstructorAndMethods (ConstructorDecl ConstructorDecl, MethodDecl MethodDecl, ListOfMethodDecls ListOfMethodDecls) {
        this.ConstructorDecl=ConstructorDecl;
        if(ConstructorDecl!=null) ConstructorDecl.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
        this.ListOfMethodDecls=ListOfMethodDecls;
        if(ListOfMethodDecls!=null) ListOfMethodDecls.setParent(this);
    }

    public ConstructorDecl getConstructorDecl() {
        return ConstructorDecl;
    }

    public void setConstructorDecl(ConstructorDecl ConstructorDecl) {
        this.ConstructorDecl=ConstructorDecl;
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
        if(ConstructorDecl!=null) ConstructorDecl.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
        if(ListOfMethodDecls!=null) ListOfMethodDecls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorDecl!=null) ConstructorDecl.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
        if(ListOfMethodDecls!=null) ListOfMethodDecls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorDecl!=null) ConstructorDecl.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        if(ListOfMethodDecls!=null) ListOfMethodDecls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBodyWithConstructorAndMethods(\n");

        if(ConstructorDecl!=null)
            buffer.append(ConstructorDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [ClassBodyWithConstructorAndMethods]");
        return buffer.toString();
    }
}
