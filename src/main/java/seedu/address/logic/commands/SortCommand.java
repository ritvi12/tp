package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.person.Address;
import seedu.address.model.person.Person;

import java.util.Comparator;
import java.util.List;

/**
 * Sorts the persons in the address book by their appointment dates.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_SUCCESS = "Sorted persons by appointment dates.";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts persons by their appointment dates in ascending order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        model.sortFilteredPersons();
        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_PERSONS); // Reset the filter to show all, which will now be sorted.

        return new CommandResult(MESSAGE_SUCCESS);
    }

}
