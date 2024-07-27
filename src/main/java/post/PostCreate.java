package post;

public class PostCreate {
    private static final String TITLE = "Absd efg hjklmn opqr stuvwxyz 1234567890";
    private static final String DESCRIPTION = "Absd efg hjklmn opqr stuvwxyz 1234567890";
    private static final String BODY = "Absd efg hjklmn opqr stuvwxyz 1234567890";
    private static final String IMAGEURL = "string";
    private static final String PUBLISHDATE = "2024-07-26T17:58:22.376Z";
    private static final boolean DRAFT = true;
    private static final String UPDATED_TITLE = "1";
    private static final String UPDATED_DESCRIPTION = "2";
    private static final String UPDATED_BODY = "A";
    private static final String UPDATED_IMAGEURL = "stringstring";
    private static final boolean UPDATED_DRAFT = false;


    private PostCreate() {
    }

    public static Post createNewPost() {
        return new Post(TITLE, DESCRIPTION, BODY, IMAGEURL, DRAFT);
    }

    public static Post createNewPostWithInvalidData() {
        return new Post("", "", "", IMAGEURL, DRAFT);
    }

    public static Post updatePostWithValidData() {
        return new Post(UPDATED_TITLE, UPDATED_DESCRIPTION, UPDATED_BODY, UPDATED_IMAGEURL, UPDATED_DRAFT);
    }
}


