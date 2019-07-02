package com.javarush.task.task17.task1717;

/* Задача 1717 - кошмар синхрнистки
Лишняя синхронизация
*/

public class Solution {
    char[] value;
    int count;

    public Solution append(CharSequence s) {
        //synchronized (Solution.class) {  //класс не статичесткий и метод не статический - значит невозможно вызвать его в статическом контекста, синхронизация по классу бесполезна
            if (s == null) {
//                synchronized (this) {// внутреняя переменная метода - к ней доступа извне
                    s = "null";
//                }
            }

            if (s instanceof String) {
//                synchronized (this) { //метод сам себя вызывает, нет никакого внешнего влияния
                    return this.append((String) s);
//                }
            }

            if (s instanceof Solution) {
//                synchronized (this) { // метод appendThis уже синхронизован дубляж ни к чему
                    return this.appendThis((Solution) s);
//                }
            }
        //}
        return this.append(s);
    }

    public synchronized Solution appendThis(Solution s) {
        //do something here....
        return this;
    }

    private static final java.io.ObjectStreamField[] serialPersistentFields =
            {
                    new java.io.ObjectStreamField("value", char[].class),
                    new java.io.ObjectStreamField("count", Integer.TYPE),
                    new java.io.ObjectStreamField("shared", Boolean.TYPE),
            };

    private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField fields = s.putFields();
//        synchronized (fields) { //метод и так уже синхронизирован по объекту, синхронизация по внутренней переменной не нужна
            fields.put("value", value);
            fields.put("count", count);
            fields.put("shared", false);
//        }
//        synchronized (s) {//аналогично - метод уже синхронизован
            s.writeFields();
//        }
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
//        synchronized (new java.io.IOException()) { //синхронизация идет по новому объекту, а используется статический класс. Т.е. эта синхронизация бесполезна
            java.io.ObjectInputStream.GetField fields = s.readFields();
            value = (char[]) fields.get("value", null);
            count = fields.get("count", 0);
//        }
    }

    public static void main(String[] args) {

    }
}
