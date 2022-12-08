// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ListMulopFactors extends ListOfMulopFactors {

    private ListOfMulopFactors ListOfMulopFactors;
    private Mulop Mulop;
    private Factor Factor;

    public ListMulopFactors (ListOfMulopFactors ListOfMulopFactors, Mulop Mulop, Factor Factor) {
        this.ListOfMulopFactors=ListOfMulopFactors;
        if(ListOfMulopFactors!=null) ListOfMulopFactors.setParent(this);
        this.Mulop=Mulop;
        if(Mulop!=null) Mulop.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
    }

    public ListOfMulopFactors getListOfMulopFactors() {
        return ListOfMulopFactors;
    }

    public void setListOfMulopFactors(ListOfMulopFactors ListOfMulopFactors) {
        this.ListOfMulopFactors=ListOfMulopFactors;
    }

    public Mulop getMulop() {
        return Mulop;
    }

    public void setMulop(Mulop Mulop) {
        this.Mulop=Mulop;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfMulopFactors!=null) ListOfMulopFactors.accept(visitor);
        if(Mulop!=null) Mulop.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfMulopFactors!=null) ListOfMulopFactors.traverseTopDown(visitor);
        if(Mulop!=null) Mulop.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfMulopFactors!=null) ListOfMulopFactors.traverseBottomUp(visitor);
        if(Mulop!=null) Mulop.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListMulopFactors(\n");

        if(ListOfMulopFactors!=null)
            buffer.append(ListOfMulopFactors.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Mulop!=null)
            buffer.append(Mulop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListMulopFactors]");
        return buffer.toString();
    }
}
