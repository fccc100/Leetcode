class TextEditor {
    StringBuilder sb;
    int point;
    public TextEditor() {
        sb = new StringBuilder();
        point = 0;
    }

    public void addText(String text) {
        sb.insert(point, text);
        point += text.length();
    }

    public int deleteText(int k) {
        int res = Math.min(k, point);
        sb.delete(Math.max(0, point - k), point);
        point -= res;
        return res;
    }

    public String cursorLeft(int k) {
        point = Math.max(0, point - k);
        return sb.substring(Math.max(0, point - 10), point);
    }

    public String cursorRight(int k) {
        point = Math.min(sb.length(), point + k);
        return sb.substring(Math.max(0, point - 10), point);
    }
}