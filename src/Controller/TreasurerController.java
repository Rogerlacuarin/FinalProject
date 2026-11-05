/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Transaction;
import Model.TreasurerModel;
import UI.ViewUi;
import utils.TransactionSorter;
import javax.swing.JOptionPane;
/**
 *
 * @author ghest
 */
public class TreasurerController {
    
   private final ViewUi view;
    private final TreasurerModel model;

    public TreasurerController(ViewUi view) {
        this.view = view;
        this.model = new TreasurerModel();
    }

    public void addTransaction() {

        String name = view.getNameInput().trim();
        String date = view.getDateInput().trim();
        String type = view.getTypeInput().trim();
        String amountText = view.getAmountInput().trim();
        String description = view.getDescriptionInput().trim();

        if (name.isEmpty() || date.isEmpty()
                || type.isEmpty() || amountText.isEmpty()
                || description.isEmpty()) {

            JOptionPane.showMessageDialog(view,
                    "Please fill in all fields.");
            return;
        }

        double amount;

        try {
            amount = Double.parseDouble(amountText);

            if (!Double.isFinite(amount) || amount < 0) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(view,
                    "Enter a valid non-negative amount.");
            return;
        }

        Transaction transaction = new Transaction(
                name, date, type, amount, description
        );

        model.addTransaction(transaction);
        view.addTransactionToTable(transaction);

        clearFields();

        JOptionPane.showMessageDialog(view,
                "Transaction successfully added!");
    }

    public void clearFields() {
        view.clearInputFields();
    }

    public void sortTransactions(String algorithm, String column) {

        TransactionSorter.sort(
                model.getTransactions(),
                algorithm,
                column
        );

        view.refreshTable(model.getTransactions());
    }
    
}
