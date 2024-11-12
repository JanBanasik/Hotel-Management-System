package pl.edu.agh.kis.pz1;

/**
 * An abstract base class representing a generic command in the hotel system.
 * Subclasses should override the {@link #execute(Hotel)} method to implement specific command logic.
 */
public abstract class Command {

    /**
     * Executes the command on the given {@link Hotel}.
     * Subclasses are expected to provide concrete implementations of this method
     * to define the behavior of specific commands.
     *
     * @param hotel the {@link Hotel} object on which the command operates
     */
    public void execute(Hotel hotel) {
        // Default implementation is empty; to be overridden by subclasses.
    }
}
