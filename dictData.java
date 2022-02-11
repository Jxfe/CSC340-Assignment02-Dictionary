public enum dictData {

    ARROW("arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
    BOOK01("book", "noun", "A set of pages."),
    BOOK02("book", "noun", "A written work published in printed or electronic form."),
    BOOK03("book", "verb", "To arrange for someone to have a seat on a plane."),
    BOOK04("book", "verb", "To arrange something on a particular date."),
    DISTINCT01("distinct", "adjective", "Familiar. Worked in Java."),
    DISTINCT02("distinct", "adjective", "Unique. No duplicates. Clearly different or of a different kind."),
    DISTINCT03("distinct", "adverb", "Uniquely. Written \"distinctly\"."),
    DISTINCT04("distinct", "noun", "A keyword in this assignment."),
    DISTINCT05("distinct", "noun", "A keyword in this assignment."),
    DISTINCT06("distinct", "noun", "A keyword in this assignment."),
    DISTINCT07("distinct", "noun", "An advanced search option."),
    DISTINCT08("distinct", "noun", "Distinct is a parameter in this assignment."),
    PLACEHOLDER01("placeholder", "adjective", "To be updated..."),
    PLACEHOLDER02("placeholder", "adjective", "To be updated..."),
    PLACEHOLDER03("placeholder", "adverb", "To be updated..."),
    PLACEHOLDER04("placeholder", "conjunction", "To be updated..."),
    PLACEHOLDER05("placeholder", "interjection", "To be updated..."),
    PLACEHOLDER06("placeholder", "noun", "To be updated..."),
    PLACEHOLDER07("placeholder", "noun", "To be updated..."),
    PLACEHOLDER08("placeholder", "noun", "To be updated..."),
    PLACEHOLDER09("placeholder", "preposition", "To be updated..."),
    PLACEHOLDER010("placeholder", "pronoun", "To be updated..."),
    PLACEHOLDER011("placeholder", "verb", "To be updated..."),
    REVERSE01("reverse", "adjective", "On back side."),
    REVERSE02("reverse", "adjective", "Opposite to usual or previous arrangement."),
    REVERSE03("reverse", "noun", "A dictionary program's parameter."),
    REVERSE04("reverse", "noun", "Change to opposite direction."),
    REVERSE05("reverse", "noun", "The opposite."),
    REVERSE06("reverse", "noun", "To be updated..."),
    REVERSE07("reverse", "noun", "To be updated..."),
    REVERSE08("reverse", "noun", "To be updated..."),
    REVERSE09("reverse", "noun", "To be updated..."),
    REVERSE010("reverse", "verb", "Change something to opposite."),
    REVERSE011("reverse", "verb", " Go back"),
    REVERSE012("reverse", "verb", "Revoke ruling."),
    REVERSE013("reverse", "verb", "To be updated..."),
    REVERSE014("reverse", "verb", "To be updated..."),
    REVERSE015("reverse", "verb", "Turn something inside out."), //Given Defs
    NOUN("noun", "noun", "a word used to identify any of a class of people, places, or things"),
    VERB01("verb", "noun", "a word used to describe an action, state, or occurrence, and forming the main part of the predicate of a sentence, such as hear, become, happen."),
    VERB02("verb", "verb", "use as a verb"), //8
    ADJECTIVE("Adjective", "noun", "a word or phrase naming an attribute, added to or grammatically related to a noun to modify or describe it."),
    ADVERB("adverb", "noun", "a word or phrase that modifies or qualifies an adjective, verb, or other adverb or a word group, expressing a relation of place, time, circumstance, manner, cause, degree, etc"),
    CONJUNCTION01("conjunction", "noun", "a word used to connect clauses or sentences or to coordinate words in the same clause"),
    CONJUNCTION02("conjunction", "noun", "the action or an instance of two or more events or things occurring at the same point in time or space."),
    INTERJECTION("interjection", "noun", "an abrupt remark, made especially as an aside or interruption."), //13
    PREPOSITION("preposition", "noun", "a word governing, and usually preceding, a noun or pronoun and expressing a relation to another word or element in the clause"),
    PRONOUN("pronoun", "noun", "a word that can function by itself as a noun phrase and that refers either to the participants in the discourse"), //15
    LOSTARK("lostark", "noun", "Lost Ark is an isometric 2.5D fantasy massively multiplayer online action role-playing game."),
    JAVA("java", "noun", "a general-purpose computer programming language designed to produce programs that will run on any computer system."),
    HTML("html", "noun", "Hypertext Markup Language, a standardized system for tagging text files to achieve font, color, graphic, and hyperlink effects on World Wide Web pages."),
    POKEMON("pokemon", "noun", "a series of Japanese video games and related media such as trading cards and television programs, featuring cartoon monsters that are captured by players and trained to battle each other."),
    CODE01("code", "noun", "a system of words, letters, figures, or other symbols substituted for other words, letters, etc., especially for the purposes of secrecy."),
    CODE02("code", "noun", "a system of signals, such as sounds, light flashes, or flags, used to send messages."),
    CODE03("code", "noun", "a series of letters, numbers, or symbols assigned to something for the purposes of classification or identification."),
    CODE04("code", "noun", "program instructions."),
    CODE05("code", "noun", "a systematic collection of laws or regulations."),//16
    CODE06("code", "verb", "convert into a particular code in order to convey a secret meaning."),
    CODE07("code", "verb", "write code for (a computer program)."),
    CODE08("code", "verb", "specify the genetic sequence for (an amino acid or protein)."); //19

    private String word;
    private String partOfSpeech;
    private String definition;

    private dictData(String word, String partOfSpeech, String definition) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
    }

    public String getWord() {
        return this.word.toLowerCase();
    }

    public String partOfSpeech() {
        return this.partOfSpeech();
    }

    public String definition() {
        return this.definition();
    }

    @Override
    public String toString() {
        return this.word + " [" + this.partOfSpeech + "] : " + this.definition;
    }
}