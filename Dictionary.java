public enum Dictionary {

    ARROW("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
    BOOK01("Book", "noun", "A set of pages."),
    BOOK02("Book", "noun", "A written work published in printed or electronic form."),
    BOOK03("Book", "verb", "To arrange for someone to have a seat on a plane."),
    BOOK04("Book", "verb", "To arrange something on a particular date."),
    DISTINCT01("Distinct", "adjective", "Familiar. Worked in Java."),
    DISTINCT02("Distinct", "adjective", "Unique. No duplicates. Clearly different or of a different kind."),
    DISTINCT03("Distinct", "adverb", "Uniquely. Written \"distinctly\"."),
    DISTINCT04("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT05("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT06("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT07("Distinct", "noun", "An advanced search option."),
    DISTINCT08("Distinct", "noun", "Distinct is a parameter in this assignment."),
    PLACEHOLDER01("Placeholder", "adjective", "To be updated..."),
    PLACEHOLDER02("Placeholder", "adjective", "To be updated..."),
    PLACEHOLDER03("Placeholder", "adverb", "To be updated..."),
    PLACEHOLDER04("Placeholder", "conjunction", "To be updated..."),
    PLACEHOLDER05("Placeholder", "interjection", "To be updated..."),
    PLACEHOLDER06("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER07("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER08("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER09("Placeholder", "preposition", "To be updated..."),
    PLACEHOLDER010("Placeholder", "pronoun", "To be updated..."),
    PLACEHOLDER011("Placeholder", "verb", "To be updated..."),
    REVERSE01("Reverse", "adjective", "On back side."),
    REVERSE02("Reverse", "adjective", "Opposite to usual or previous arrangement."),
    REVERSE03("Reverse", "noun", "A dictionary program's parameter."),
    REVERSE04("Reverse", "noun", "Change to opposite direction."),
    REVERSE05("Reverse", "noun", "The opposite."),
    REVERSE06("Reverse", "noun", "To be updated..."),
    REVERSE07("Reverse", "noun", "To be updated..."),
    REVERSE08("Reverse", "noun", "To be updated..."),
    REVERSE09("Reverse", "noun", "To be updated..."),
    REVERSE010("Reverse", "verb", "Change something to opposite."),
    REVERSE011("Reverse", "verb", "Go back"),
    REVERSE012("Reverse", "verb", "Revoke ruling."),
    REVERSE013("Reverse", "verb", "To be updated..."),
    REVERSE014("Reverse", "verb", "To be updated..."),
    REVERSE015("Reverse", "verb", "Turn something inside out."),
    NOUN("Noun", "noun", "a word used to identify any of a class of people, places, or things"),
    VERB01("Verb", "noun", "a word used to describe an action, state, or occurrence, and forming the main part of the predicate of a sentence, such as hear, become, happen."),
    VERB02("Verb", "verb", "use as a verb"), 
    ADJECTIVE("Adjective", "noun", "a word or phrase naming an attribute, added to or grammatically related to a noun to modify or describe it."),
    ADVERB("Adverb", "noun", "a word or phrase that modifies or qualifies an adjective, verb, or other adverb or a word group"),
    CONJUNCTION01("Conjunction", "noun", "a word used to connect clauses or sentences or to coordinate words in the same clause"),
    CONJUNCTION02("Conjunction", "noun", "the action or an instance of two or more events or things occurring at the same point in time or space."),
    INTERJECTION("Interjection", "noun", "an abrupt remark, made especially as an aside or interruption."), 
    PREPOSITION("Preposition", "noun", "a word governing, and usually preceding, a noun or pronoun and expressing a relation to another word or element in the clause"),
    PRONOUN("Pronoun", "noun", "a word that can function by itself as a noun phrase and that refers either to the participants in the discourse"), 
    LOSTARK("Lostark", "noun", "Lost Ark is an isometric 2.5D fantasy massively multiplayer online action role-playing game."),
    JAVA("Java", "noun", "a general-purpose computer programming language designed to produce programs that will run on any computer system."),
    HTML("Html", "noun", "Hypertext Markup Language, a standardized system for tagging text files to achieve font, color, graphic, and hyperlink effects on World Wide Web pages."),
    POKEMON("Pokemon", "noun", "a series of Japanese video games and related media such as trading cards and television programs"),
    CODE01("Code", "noun", "a system of words, letters, figures, or other symbols substituted for other words, letters, etc., especially for the purposes of secrecy."),
    CODE02("Code", "noun", "a system of signals, such as sounds, light flashes, or flags, used to send messages."),
    CODE03("Code", "noun", "a series of letters, numbers, or symbols assigned to something for the purposes of classification or identification."),
    CODE04("Code", "noun", "program instructions."),
    CODE05("Code", "noun", "a systematic collection of laws or regulations."),
    CODE06("Code", "verb", "convert into a particular code in order to convey a secret meaning."),
    CODE07("Code", "verb", "write code for (a computer program)."),
    DOOMED("Doomed", "adjective", "likely to have an unfortunate and inescapable outcome; ill-fated.");

    private String word;
    private String partOfSpeech;
    private String definition;

    private Dictionary(String word, String partOfSpeech, String definition) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
    }

    public String getWord() {
        return this.word;
    }

    public String getPartOfSpeech() {
        return this.partOfSpeech;
    }

    public String getDefinition() {
        return this.definition;
    }

    @Override
    public String toString() {
        return this.word + " [" + this.partOfSpeech + "] : " + this.definition;
    }
}