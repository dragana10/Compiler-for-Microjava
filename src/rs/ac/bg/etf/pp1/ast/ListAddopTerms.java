// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ListAddopTerms extends ListOfAddopTerms {

    private ListOfAddopTerms ListOfAddopTerms;
    private Addop Addop;
    private Term Term;

    public ListAddopTerms (ListOfAddopTerms ListOfAddopTerms, Addop Addop, Term Term) {
        this.ListOfAddopTerms=ListOfAddopTerms;
        if(ListOfAddopTerms!=null) ListOfAddopTerms.setParent(this);
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public ListOfAddopTerms getListOfAddopTerms() {
        return ListOfAddopTerms;
    }

    public void setListOfAddopTerms(ListOfAddopTerms ListOfAddopTerms) {
        this.ListOfAddopTerms=ListOfAddopTerms;
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfAddopTerms!=null) ListOfAddopTerms.accept(visitor);
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfAddopTerms!=null) ListOfAddopTerms.traverseTopDown(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfAddopTerms!=null) ListOfAddopTerms.traverseBottomUp(visitor);
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListAddopTerms(\n");

        if(ListOfAddopTerms!=null)
            buffer.append(ListOfAddopTerms.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListAddopTerms]");
        return buffer.toString();
    }
}
