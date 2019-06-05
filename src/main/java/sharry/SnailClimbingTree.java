package sharry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SnailClimbingTree {

    private String name;
    private Phase phase;
    private int day;
    private int climbedDistance;
    private int treeHeight;
    private boolean debugging;

}
