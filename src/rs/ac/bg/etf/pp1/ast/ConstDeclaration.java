// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclaration extends ConstDecl {

    private Type Type;
    private ConstExp ConstExp;
    private ListOfConstExps ListOfConstExps;

    public ConstDeclaration (Type Type, ConstExp ConstExp, ListOfConstExps ListOfConstExps) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstExp=ConstExp;
        if(ConstExp!=null) ConstExp.setParent(this);
        this.ListOfConstExps=ListOfConstExps;
        if(ListOfConstExps!=null) ListOfConstExps.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstExp getConstExp() {
        return ConstExp;
    }

    public void setConstExp(ConstExp ConstExp) {
        this.ConstExp=ConstExp;
    }

    public ListOfConstExps getListOfConstExps() {
        return ListOfConstExps;
    }

    public void setListOfConstExps(ListOfConstExps ListOfConstExps) {
        this.ListOfConstExps=ListOfConstExps;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstExp!=null) ConstExp.accept(visitor);
        if(ListOfConstExps!=null) ListOfConstExps.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstExp!=null) ConstExp.traverseTopDown(visitor);
        if(ListOfConstExps!=null) ListOfConstExps.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstExp!=null) ConstExp.traverseBottomUp(visitor);
        if(ListOfConstExps!=null) ListOfConstExps.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstExp!=null)
            buffer.append(ConstExp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfConstExps!=null)
            buffer.append(ListOfConstExps.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclaration]");
        return buffer.toString();
    }
}
