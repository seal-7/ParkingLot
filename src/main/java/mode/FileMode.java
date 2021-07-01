package mode;

import exception.InvalidCommandException;
import factory.CommandExecutorFactory;
import model.Command;

import java.io.*;

public class FileMode extends Mode {

    private final String fileName;

    public FileMode(final CommandExecutorFactory commandExecutorFactory,
                    final String fileName) {
        super(commandExecutorFactory);
        this.fileName = fileName;
    }


    @Override
    public void process() throws InvalidCommandException {
        final File file = new File(fileName);
        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String input = bufferedReader.readLine();
            while(input != null) {
                final Command command = new Command(input);
                processCommand(command);
                input = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
