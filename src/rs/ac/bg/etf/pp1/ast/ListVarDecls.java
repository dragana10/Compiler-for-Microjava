// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ListVarDecls extends ListOfVarDecls {

    private ListOfVarDecls ListOfVarDecls;
    private VarDeclSingle VarDeclSingle;

    public ListVarDecls (ListOfVarDecls ListOfVarDecls, VarDeclSingle VarDeclSingle) {
        this.ListOfVarDecls=ListOfVarDecls;
        if(ListOfVarDecls!=null) ListOfVarDecls.setParent(this);
        this.VarDeclSingle=VarDeclSingle;
        if(VarDeclSingle!=null) VarDeclSingle.setParent(this);
    }

    public ListOfVarDecls getListOfVarDecls() {
        return ListOfVarDecls;
    }

    public void setListOfVarDecls(ListOfVarDecls ListOfVarDecls) {
        this.ListOfVarDecls=ListOfVarDecls;
    }

    public VarDeclSingle getVarDeclSingle() {
        return VarDeclSingle;
    }

    public void setVarDeclSingle(VarDeclSingle VarDeclSingle) {
        this.VarDeclSingle=VarDeclSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfVarDecls!=null) ListOfVarDecls.accept(visitor);
        if(VarDeclSingle!=null) VarDeclSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfVarDecls!=null) ListOfVarDecls.traverseTopDown(visitor);
        if(VarDeclSingle!=null) VarDeclSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfVarDecls!=null) ListOfVarDecls.traverseBottomUp(visitor);
        if(VarDeclSingle!=null) VarDeclSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListVarDecls(\n");

        if(ListOfVarDecls!=null)
            buffer.append(ListOfVarDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclSingle!=null)
            buffer.append(VarDeclSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListVarDecls]");
        return buffer.toString();
    }
}
