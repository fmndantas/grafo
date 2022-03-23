package com.fernando.gui.reaction;

import com.fernando.gui.event.EventGui;
import com.fernando.gui.Manager;
import com.fernando.gui.enums.ReactionStatusEnum;

import javax.swing.*;

public abstract class Reaction {
    protected final Manager manager;
    protected ReactionStatusEnum status;

    public Reaction(Manager manager) {
        this.manager = manager;
        this.status = ReactionStatusEnum.CREATED;
    }

    protected abstract void executeReaction(EventGui e);

    protected void executeAfterReaction(EventGui e) {
        manager.updateBoard();
        if (status == ReactionStatusEnum.FINALIZED) {
            recreateReaction();
        }
    }

    public void execute(EventGui e) {
        executeReaction(e);
        executeAfterReaction(e);
    }

    public void executeReactionInBackground(EventGui e) {
        var worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                try {
                    Reaction.this.execute(e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        };
        worker.execute();
    }

    void recreateReaction() {
        status = ReactionStatusEnum.CREATED;
    }
}
