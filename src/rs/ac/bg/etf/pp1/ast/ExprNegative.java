// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ExprNegative extends ExprSingle {

    private Term Term;
    private ListOfAddopTerms ListOfAddopTerms;

    public ExprNegative (Term Term, ListOfAddopTerms ListOfAddopTerms) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.ListOfAddopTerms=ListOfAddopTerms;
        if(ListOfAddopTerms!=null) ListOfAddopTerms.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public ListOfAddopTerms getListOfAddopTerms() {
        return ListOfAddopTerms;
    }

    public void setListOfAddopTerms(ListOfAddopTerms ListOfAddopTerms) {
        this.ListOfAddopTerms=ListOfAddopTerms;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(ListOfAddopTerms!=null) ListOfAddopTerms.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(ListOfAddopTerms!=null) ListOfAddopTerms.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(ListOfAddopTerms!=null) ListOfAddopTerms.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprNegative(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfAddopTerms!=null)
            buffer.append(ListOfAddopTerms.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprNegative]");
        return buffer.toString();
    }
}
