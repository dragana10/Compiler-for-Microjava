// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class RecordDeclaration extends RecordDecl {

    private String I1;
    private ListOfVarDecls ListOfVarDecls;

    public RecordDeclaration (String I1, ListOfVarDecls ListOfVarDecls) {
        this.I1=I1;
        this.ListOfVarDecls=ListOfVarDecls;
        if(ListOfVarDecls!=null) ListOfVarDecls.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ListOfVarDecls getListOfVarDecls() {
        return ListOfVarDecls;
    }

    public void setListOfVarDecls(ListOfVarDecls ListOfVarDecls) {
        this.ListOfVarDecls=ListOfVarDecls;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfVarDecls!=null) ListOfVarDecls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfVarDecls!=null) ListOfVarDecls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfVarDecls!=null) ListOfVarDecls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDeclaration(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ListOfVarDecls!=null)
            buffer.append(ListOfVarDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecordDeclaration]");
        return buffer.toString();
    }
}
