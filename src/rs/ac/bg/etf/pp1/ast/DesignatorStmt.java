// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmt extends DesignatorStatement {

    private DesignatorStatementParams DesignatorStatementParams;

    public DesignatorStmt (DesignatorStatementParams DesignatorStatementParams) {
        this.DesignatorStatementParams=DesignatorStatementParams;
        if(DesignatorStatementParams!=null) DesignatorStatementParams.setParent(this);
    }

    public DesignatorStatementParams getDesignatorStatementParams() {
        return DesignatorStatementParams;
    }

    public void setDesignatorStatementParams(DesignatorStatementParams DesignatorStatementParams) {
        this.DesignatorStatementParams=DesignatorStatementParams;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementParams!=null) DesignatorStatementParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementParams!=null) DesignatorStatementParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementParams!=null) DesignatorStatementParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmt(\n");

        if(DesignatorStatementParams!=null)
            buffer.append(DesignatorStatementParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmt]");
        return buffer.toString();
    }
}
