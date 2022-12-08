// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class MulVariableDecls extends MulVarDecls {

    private MulVarDecls MulVarDecls;
    private VarDecl VarDecl;

    public MulVariableDecls (MulVarDecls MulVarDecls, VarDecl VarDecl) {
        this.MulVarDecls=MulVarDecls;
        if(MulVarDecls!=null) MulVarDecls.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public MulVarDecls getMulVarDecls() {
        return MulVarDecls;
    }

    public void setMulVarDecls(MulVarDecls MulVarDecls) {
        this.MulVarDecls=MulVarDecls;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulVarDecls!=null) MulVarDecls.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulVarDecls!=null) MulVarDecls.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulVarDecls!=null) MulVarDecls.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulVariableDecls(\n");

        if(MulVarDecls!=null)
            buffer.append(MulVarDecls.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulVariableDecls]");
        return buffer.toString();
    }
}
