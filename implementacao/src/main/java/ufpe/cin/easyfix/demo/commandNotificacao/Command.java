package ufpe.cin.easyfix.demo.commandNotificacao;

import ufpe.cin.easyfix.demo.subsistemaNotificacao.Notificacao;

public interface Command {
    public void execute(Notificacao notificacao);
}
