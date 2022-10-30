package econtoolbox.economist.gdp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kaiaccount.account.inter.event.TransactionCompletedEvent;
import org.kaiaccount.account.inter.transfer.result.successful.SuccessfulTransactionResult;

public class GDPListener implements Listener {

    @EventHandler
    public void onTransactionEvent(TransactionCompletedEvent event) {
        if(!(event instanceof SuccessfulTransactionResult)){
            return;
        }
        long transactionAmount = event.getTransaction().getTransactions()
                .parallelStream()
                .mapToLong(value -> value.getPayment().getAmount().intValue())
                .sum();

        // TODO use this value lol
    }
}
