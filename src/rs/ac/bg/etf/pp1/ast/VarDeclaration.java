// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class VarDeclaration extends VarDecl {

    private Type Type;
    private VarDeclSingle VarDeclSingle;
    private ListOfVarDecls ListOfVarDecls;

    public VarDeclaration (Type Type, VarDeclSingle VarDeclSingle, ListOfVarDecls ListOfVarDecls) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDeclSingle=VarDeclSingle;
        if(VarDeclSingle!=null) VarDeclSingle.setParent(this);
        this.ListOfVarDecls=ListOfVarDecls;
        if(ListOfVarDecls!=null) ListOfVarDecls.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarDeclSingle getVarDeclSingle() {
        return VarDeclSingle;
    }

    public void setVarDeclSingle(VarDeclSingle VarDeclSingle) {
        this.VarDeclSingle=VarDeclSingle;
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
        if(Type!=null) Type.accept(visitor);
        if(VarDeclSingle!=null) VarDeclSingle.accept(visitor);
        if(ListOfVarDecls!=null) ListOfVarDecls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDeclSingle!=null) VarDeclSingle.traverseTopDown(visitor);
        if(ListOfVarDecls!=null) ListOfVarDecls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDeclSingle!=null) VarDeclSingle.traverseBottomUp(visitor);
        if(ListOfVarDecls!=null) ListOfVarDecls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclSingle!=null)
            buffer.append(VarDeclSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfVarDecls!=null)
            buffer.append(ListOfVarDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclaration]");
        return buffer.toString();
    }
}
