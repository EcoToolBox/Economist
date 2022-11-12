package econtoolbox.economist.gdp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kaiaccount.account.inter.event.TransactionCompletedEvent;
import org.kaiaccount.account.inter.transfer.result.successful.SuccessfulTransactionResult;

import java.math.BigDecimal;

public class GDPListener implements Listener {

    @EventHandler
    public void onTransactionEvent(TransactionCompletedEvent event) {
        if(!(event instanceof SuccessfulTransactionResult)){
            return;
        }
        BigDecimal transactionAmount = event.getTransaction().getTransactions()
                .parallelStream()
                .map(value -> value.getPayment().getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);


    }
}
