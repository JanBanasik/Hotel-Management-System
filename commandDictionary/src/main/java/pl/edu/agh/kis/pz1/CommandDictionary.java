package pl.edu.agh.kis.pz1;

import org.reflections.Reflections;
import pl.edu.agh.kis.pz1.util.MyMap;
import pl.edu.agh.kis.pz1.util.Map;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * A utility class for creating a dictionary of commands by scanning for
 * all subclasses of the {@link Command} interface in the specified package.
 * The class provides functionality to dynamically instantiate commands
 * and associate them with their corresponding keys.
 */
public class CommandDictionary {

    /**
     * Private constructor to prevent instantiation of this utility class.
     * Calling this constructor will throw an {@link IllegalStateException}.
     */
    private CommandDictionary() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Creates and returns a dictionary of commands.
     * This method scans the `pl.edu.agh.kis.pz1` package for all subclasses
     * of the {@link Command} interface, dynamically instantiates them,
     * and maps their simple class names (converted to camelCase) as keys
     * to their instances as values.
     *
     * @return a map of command names (keys) to their corresponding {@link Command} instances (values)
     * @throws NoSuchMethodException    if the no-argument constructor is not found for a command class
     * @throws InvocationTargetException if the constructor invocation throws an exception
     * @throws InstantiationException    if instantiation of a command class fails
     * @throws IllegalAccessException    if the constructor is not accessible
     */
    public static Map<String, Command> getCommandDictionary()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, Command> commands = new MyMap<>();

        // Use Reflections library to find all subclasses of Command
        Reflections reflections = new Reflections("pl.edu.agh.kis.pz1");
        Set<Class<? extends Command>> commandClasses = reflections.getSubTypesOf(Command.class);

        for (Class<? extends Command> commandClass : commandClasses) {
            // Convert class name to camelCase to use as a dictionary key
            String className = commandClass.getSimpleName().replace("Command", "");
            className = className.substring(0, 1).toLowerCase() + className.substring(1);

            // Instantiate the command using its no-argument constructor
            Command commandInstance = commandClass.getDeclaredConstructor().newInstance();
            commands.put(className, commandInstance);
        }

        return commands;
    }
}
