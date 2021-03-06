/*
 *
 *      Copyright 2018 Niklas Arndt
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package me.niklas.postie.command.managment;

import me.niklas.postie.command.Command;
import me.niklas.postie.command.Result;
import me.niklas.postie.core.Postie;
import net.dv8tion.jda.core.entities.Message;

/**
 * Created by Niklas on 23.06.2018 in postie
 */
public class DisableCommand implements Command {

    @Override
    public String getName() {
        return "disable";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"deactivate"};
    }

    @Override
    public String getDescription() {
        return "Disables a commands, makes it inaccessible for users.";
    }

    @Override
    public String[] getExamples() {
        return new String[]{"disable vote", "disable dice"};
    }

    @Override
    public int getRequiredLevel() {
        return 3;
    }

    @Override
    public Result execute(Message message, String[] args) {
        if (args.length != 1) return Postie.getInstance().getStandardsManager().getExamples(this, message);

        if (Postie.getInstance().getCommandManager().getCommands().stream().noneMatch(
                command -> command.getName().equalsIgnoreCase(args[0]))) {
            return new Result("Error", String.format("The command `%s` was not found!", args[0].toLowerCase()), message);
        }
        if (args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("disable")) {
            return new Result(String.format("You can not disable `%s`!", args[0].toLowerCase()), message);
        }
        Postie.getInstance().getCommandManager().disableCommand(message.getGuild().getId(), args[0]);
        return new Result("Disabled", String.format("The command `%s` has been disabled.", args[0].toLowerCase()), message).deleteOrigin(true);
    }
}