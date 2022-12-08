// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class ListStatements extends ListOfStatements {

    private ListOfStatements ListOfStatements;
    private StatementOnly StatementOnly;

    public ListStatements (ListOfStatements ListOfStatements, StatementOnly StatementOnly) {
        this.ListOfStatements=ListOfStatements;
        if(ListOfStatements!=null) ListOfStatements.setParent(this);
        this.StatementOnly=StatementOnly;
        if(StatementOnly!=null) StatementOnly.setParent(this);
    }

    public ListOfStatements getListOfStatements() {
        return ListOfStatements;
    }

    public void setListOfStatements(ListOfStatements ListOfStatements) {
        this.ListOfStatements=ListOfStatements;
    }

    public StatementOnly getStatementOnly() {
        return StatementOnly;
    }

    public void setStatementOnly(StatementOnly StatementOnly) {
        this.StatementOnly=StatementOnly;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfStatements!=null) ListOfStatements.accept(visitor);
        if(StatementOnly!=null) StatementOnly.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfStatements!=null) ListOfStatements.traverseTopDown(visitor);
        if(StatementOnly!=null) StatementOnly.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfStatements!=null) ListOfStatements.traverseBottomUp(visitor);
        if(StatementOnly!=null) StatementOnly.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListStatements(\n");

        if(ListOfStatements!=null)
            buffer.append(ListOfStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementOnly!=null)
            buffer.append(StatementOnly.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListStatements]");
        return buffer.toString();
    }
}
