import java.util.PriorityQueue;

public class CastTree {

    private Actor root;

    //Constructor
    public CastTree() {
        this.root = null;
    }

    //Adds the actor to the tree, calls the recursive method
    public void addActor(String actorFirstName,String actorLastName,String actorRole) {
        root = addActor(root, actorFirstName,actorLastName,actorRole);
    }

    private Actor addActor(Actor root, String actorFirstName,String actorLastName,String actorRole) {
        // --------------------------------------------------------
        // Summary: Adds the new actor to the three
        // Precondtiton:
        // Postcondition: Given actor is added.
        // --------------------------------------------------------
        if (root == null) {
            root = new Actor(actorFirstName,actorLastName,actorRole);
            return root;
        }
        String fullName = actorFirstName+" "+actorLastName;
        if (fullName.compareTo(root.getFullname()) > 0) {
            root.right = addActor(root.right, actorFirstName,actorLastName,actorRole);
        }
        else {
            root.left = addActor(root.left, actorFirstName,actorLastName,actorRole);
        }
        return root;
    }


    public void removeActor(String actorFirstName,String actorLastName) {
        root = removeActor(root, actorFirstName,actorLastName);
    }

    private Actor removeActor(Actor root, String actorFirstName,String actorLastName) {
        // --------------------------------------------------------
        // Summary: Removes the actor according to the name
        // Precondition: actor name is a string, and actor should exists.
        // Postcondition: actor is removed.
        // --------------------------------------------------------
        if (root == null) {
            return null;
        }
        String fullName = actorFirstName+" "+actorLastName;
        if (!root.getFullname().equals(fullName)) {
            root.right = removeActor(root.right, actorFirstName,actorLastName);
            root.left = removeActor(root.left, actorFirstName,actorLastName);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            root = min(root.right);
            root.right = removeActor(root.right, root.getFirst_Name(),root.getLast_Name());
        }
        return root;
    }
    public Actor returnActor(String actorFirstName,String actorLastName) {
        return returnActor(root, actorFirstName,actorLastName);
    }

    private Actor returnActor(Actor root, String actorFirstName,String actorLastName) {
        // --------------------------------------------------------
        // Summary: Finds the given Actor recursively and return its data.
        // Precondition: Given cast member should exists.
        // Postcondition: the actor is returned
        // --------------------------------------------------------
        Actor fLeft = null;
        Actor fRight = null;
        String fullName = actorFirstName+" "+actorLastName;
        if (root == null) {
            return null;
        }
        if (root.getFullname().equals(fullName)) {
            return root;
        }
        if (root.right != null) {
            fRight = returnActor(root.right, actorFirstName,actorLastName);
        }

        if (root.left != null) {
            fLeft = returnActor(root.left, actorFirstName,actorLastName);
        }
        if (fLeft != null)
            return fLeft;
        else if (fRight != null)
            return fRight;
        else
            return null;

    }
    private Actor min(Actor root) {
        // --------------------------------------------------------
        // Summary: returns the min node
        // --------------------------------------------------------
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public String displayActors() {
        return displayActors(root);
    }
    private String displayActors(Actor root) {
        // --------------------------------------------------------
        // Summary: Prints the actors in an ascending order
        // --------------------------------------------------------
        if (root == null) {
            return "";
        }
        String data = root.getFullname()+" "+root.getRole();
        return displayActors(root.left) + "\n" + data + displayActors(root.right);

    }
}
