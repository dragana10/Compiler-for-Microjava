// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ProgramName ProgramName;
    private ListOfDeclForProg ListOfDeclForProg;
    private ListOfMethodDecls ListOfMethodDecls;

    public Program (ProgramName ProgramName, ListOfDeclForProg ListOfDeclForProg, ListOfMethodDecls ListOfMethodDecls) {
        this.ProgramName=ProgramName;
        if(ProgramName!=null) ProgramName.setParent(this);
        this.ListOfDeclForProg=ListOfDeclForProg;
        if(ListOfDeclForProg!=null) ListOfDeclForProg.setParent(this);
        this.ListOfMethodDecls=ListOfMethodDecls;
        if(ListOfMethodDecls!=null) ListOfMethodDecls.setParent(this);
    }

    public ProgramName getProgramName() {
        return ProgramName;
    }

    public void setProgramName(ProgramName ProgramName) {
        this.ProgramName=ProgramName;
    }

    public ListOfDeclForProg getListOfDeclForProg() {
        return ListOfDeclForProg;
    }

    public void setListOfDeclForProg(ListOfDeclForProg ListOfDeclForProg) {
        this.ListOfDeclForProg=ListOfDeclForProg;
    }

    public ListOfMethodDecls getListOfMethodDecls() {
        return ListOfMethodDecls;
    }

    public void setListOfMethodDecls(ListOfMethodDecls ListOfMethodDecls) {
        this.ListOfMethodDecls=ListOfMethodDecls;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramName!=null) ProgramName.accept(visitor);
        if(ListOfDeclForProg!=null) ListOfDeclForProg.accept(visitor);
        if(ListOfMethodDecls!=null) ListOfMethodDecls.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramName!=null) ProgramName.traverseTopDown(visitor);
        if(ListOfDeclForProg!=null) ListOfDeclForProg.traverseTopDown(visitor);
        if(ListOfMethodDecls!=null) ListOfMethodDecls.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramName!=null) ProgramName.traverseBottomUp(visitor);
        if(ListOfDeclForProg!=null) ListOfDeclForProg.traverseBottomUp(visitor);
        if(ListOfMethodDecls!=null) ListOfMethodDecls.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgramName!=null)
            buffer.append(ProgramName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfDeclForProg!=null)
            buffer.append(ListOfDeclForProg.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfMethodDecls!=null)
            buffer.append(ListOfMethodDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
