// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ConstExpsList extends ListOfConstExps {

    private ListOfConstExps ListOfConstExps;
    private ConstExp ConstExp;

    public ConstExpsList (ListOfConstExps ListOfConstExps, ConstExp ConstExp) {
        this.ListOfConstExps=ListOfConstExps;
        if(ListOfConstExps!=null) ListOfConstExps.setParent(this);
        this.ConstExp=ConstExp;
        if(ConstExp!=null) ConstExp.setParent(this);
    }

    public ListOfConstExps getListOfConstExps() {
        return ListOfConstExps;
    }

    public void setListOfConstExps(ListOfConstExps ListOfConstExps) {
        this.ListOfConstExps=ListOfConstExps;
    }

    public ConstExp getConstExp() {
        return ConstExp;
    }

    public void setConstExp(ConstExp ConstExp) {
        this.ConstExp=ConstExp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfConstExps!=null) ListOfConstExps.accept(visitor);
        if(ConstExp!=null) ConstExp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfConstExps!=null) ListOfConstExps.traverseTopDown(visitor);
        if(ConstExp!=null) ConstExp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfConstExps!=null) ListOfConstExps.traverseBottomUp(visitor);
        if(ConstExp!=null) ConstExp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstExpsList(\n");

        if(ListOfConstExps!=null)
            buffer.append(ListOfConstExps.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstExp!=null)
            buffer.append(ConstExp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstExpsList]");
        return buffer.toString();
    }
}
