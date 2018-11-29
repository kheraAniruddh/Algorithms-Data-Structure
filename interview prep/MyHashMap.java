class MyHashMap {
    private static final int SIZE = 32;

    class Entry {
        String key;
        String value;
        Entry next;
        Entry(String key, String value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    private Entry[] table;

    public MyHashMap() {
        table = new Entry[SIZE];
    }

    public void put(String key, String value) {
        Entry entry = new Entry(key, value);
        int code = key.hashCode() % SIZE;
        if (table[code] == null) {
            table[code] = entry;
        } else {
            addOrUpdateNode(table[code], entry);
        }
    }

    public String get(String key) {
        int code = key.hashCode() % SIZE;
        Entry head = table[code];
        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    public void remove(String key) {
        int code = key.hashCode() % SIZE;
        Entry head = table[code];
        Entry dummy = new Entry("0", "0");
        dummy.next = head;
        Entry prev = dummy;
        while (head != null) {
            if (head.key.equals(key)) prev.next = head.next;
            prev = head;
            head = head.next;
        }
        table[code] = dummy.next;
    }

    public boolean containsKey(String key) {
        int code = key.hashCode() % SIZE;
        Entry head = table[code];
        while (head != null) {
            if (head.key.equals(key)) return true;
            head = head.next;
        }
        return false;
    }

    private void addOrUpdateNode(Entry head, Entry node) {
        Entry prev = head;
        while (head != null) {
            if (head.key.equals(node.key)) {
                head.value = node.value;
                return;
            }
            prev = head;
            head = head.next;
        }
        prev.next = node;
    }

    public static void main(String[] args) {
        MyHashMap map= new MyHashMap();
        map.put("a","abs");
        // System.out.println(map.get("a"));
        map.put("a","abc");
        // System.out.println(map.get("a"));
        map.put("b","abs");
        // System.out.println(map.get("b"));
        map.put("c","abx");
        // System.out.println(map.get("c"));
        for(Entry e: map.table)
            System.out.println(e.key+" "+e.value+" "+e.next);



    }
}