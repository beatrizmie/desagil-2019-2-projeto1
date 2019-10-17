package br.pro.hashi.ensino.desagil.projeto1;

import android.util.Log;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

// Não é permitido mudar nada nessa classe
// exceto o recheio dos três métodos.

public class Translator {

    private final Node root;
    private final HashMap<Character, Node> map;

    // Você deve mudar o recheio deste construtor,
    // de acordo com os requisitos não-funcionais.

    public Translator() {

        // raiz

        root = new Node(' ');
        map = new HashMap<>();
        map.put(' ', root);

        // primeira linha

        Node e = new Node('e');
        root.setLeft(e);
        e.setParent(root);
        map.put('e', e);

        Node t = new Node('t');
        root.setRight(t);
        t.setParent(root);
        map.put('t', t);

        // segunda linha

        Node i = new Node('i');
        e.setLeft(i);
        i.setParent(e);
        map.put('i', i);

        Node a = new Node('a');
        e.setRight(a);
        a.setParent(e);
        map.put('a', a);

        Node n = new Node('n');
        t.setLeft(n);
        n.setParent(t);
        map.put('n', n);

        Node m = new Node('m');
        t.setRight(m);
        m.setParent(t);
        map.put('m', m);

        // terceira linha

        Node s = new Node('s');
        i.setLeft(s);
        s.setParent(i);
        map.put('s', s);

        Node u = new Node('u');
        i.setRight(u);
        u.setParent(i);
        map.put('u', u);

        Node r = new Node('r');
        a.setLeft(r);
        r.setParent(a);
        map.put('r', r);

        Node w = new Node('w');
        a.setRight(w);
        w.setParent(a);
        map.put('w', w);

        Node d = new Node('d');
        n.setLeft(d);
        d.setParent(n);
        map.put('d', d);

        Node k = new Node('k');
        n.setRight(k);
        k.setParent(n);
        map.put('k', k);

        Node g = new Node('g');
        m.setLeft(g);
        g.setParent(m);
        map.put('g', g);

        Node o = new Node('o');
        m.setRight(o);
        o.setParent(m);
        map.put('o', o);

        // quarta linha

        Node h = new Node('h');
        s.setLeft(h);
        h.setParent(s);
        map.put('h', h);

        Node v = new Node('v');
        s.setRight(v);
        v.setParent(s);
        map.put('v', v);

        Node f = new Node('f');
        u.setLeft(f);
        f.setParent(u);
        map.put('f', f);

        Node vazio1 = new Node(' ');
        u.setRight(vazio1);
        vazio1.setParent(u);

        Node l = new Node('l');
        r.setLeft(l);
        l.setParent(r);
        map.put('l', l);

        Node vazio2 = new Node(' ');
        r.setRight(vazio2);
        vazio2.setParent(r);

        Node p = new Node('p');
        w.setLeft(p);
        p.setParent(w);
        map.put('p', p);

        Node j = new Node('j');
        w.setRight(j);
        j.setParent(w);
        map.put('j', j);

        Node b = new Node('b');
        d.setLeft(b);
        b.setParent(d);
        map.put('b', b);

        Node x = new Node('x');
        d.setRight(x);
        x.setParent(d);
        map.put('x', x);

        Node c = new Node('c');
        k.setLeft(c);
        c.setParent(k);
        map.put('c', c);

        Node y = new Node('y');
        k.setRight(y);
        y.setParent(k);
        map.put('y', y);

        Node z = new Node('z');
        g.setLeft(z);
        z.setParent(g);
        map.put('z', z);

        Node q = new Node('q');
        g.setRight(q);
        q.setParent(g);
        map.put('q', q);

        Node vazio3 = new Node(' ');
        o.setLeft(vazio3);
        vazio3.setParent(o);

        Node vazio4 = new Node(' ');
        o.setRight(vazio4);
        vazio4.setParent(o);

        // quinta linha

        Node n5 = new Node('5');
        h.setLeft(n5);
        n5.setParent(h);
        map.put('5', n5);

        Node n4 = new Node('4');
        h.setRight(n4);
        n4.setParent(h);
        map.put('4', n4);

        Node n3 = new Node('3');
        v.setRight(n3);
        n3.setParent(v);
        map.put('3', n3);

        Node n2 = new Node('2');
        vazio1.setRight(n2);
        n2.setParent(vazio1);
        map.put('2', n2);

        Node mais = new Node('+');
        vazio2.setLeft(mais);
        mais.setParent(vazio2);
        map.put('+', mais);

        Node n1 = new Node('1');
        j.setRight(n1);
        n1.setParent(j);
        map.put('1', n1);

        Node n6 = new Node('6');
        b.setLeft(n6);
        n6.setParent(b);
        map.put('6', n6);

        Node igual = new Node('=');
        b.setRight(igual);
        igual.setParent(b);
        map.put('=', igual);

        Node barra = new Node('/');
        x.setLeft(barra);
        barra.setParent(x);
        map.put('/', barra);

        Node n7 = new Node('7');
        z.setLeft(n7);
        n7.setParent(z);
        map.put('7', n7);

        Node n8 = new Node('8');
        vazio3.setLeft(n8);
        n8.setParent(vazio3);
        map.put('8', n8);

        Node n9 = new Node('9');
        vazio4.setLeft(n9);
        n9.setParent(vazio4);
        map.put('9', n9);

        Node n0 = new Node('0');
        vazio4.setRight(n0);
        n0.setParent(vazio4);
        map.put('0', n0);

    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.

    public char morseToChar(String code) {

        Node atual = root;

        for (int i = 0; i < code.length(); i++) {
            char morse = code.charAt(i);

            if (morse == '.') {
                atual = atual.getLeft();
            } else if (morse == '-') {
                atual = atual.getRight();
            } else {
                return ' ';
            }
        }

         return atual.getValue();

    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.

    public String charToMorse(char c) {

        Node atual = map.get(c);
        Node last = map.get(c);
        String morse = "";

        while (atual != root) {
            atual = atual.getParent();
            if (atual.getLeft() == last) {
                morse = '.' + morse;
            }
            else if (atual.getRight() == last) {
                morse = '-' + morse;
            }
            last = last.getParent();
        }

        return morse;

    }


    // Você deve mudar o recheio deste método, de
    // acordo com os requisitos não-funcionais.

    public LinkedList<String> getCodes() {
        LinkedList<String> lista = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.element();
            Node left = node.getLeft();
            Node right = node.getRight();

            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (node.getValue() != '!' && node.getValue() != '+' && node.getValue() != '/' && node.getValue() != '=' && node.getValue() != '*'  && node.getValue() != ' ') {
                lista.add(charToMorse(node.getValue()));
            }
            queue.remove();
        }

        return lista;

    }

    // Dicionário

    public ArrayList<String> DicionarioRomanoMorse() {
        ArrayList<String> ListaAlfabeticaRomano = new ArrayList<>();

        for (HashMap.Entry<Character, Node> entry: map.entrySet()) {
            Character key = entry.getKey();
            String Morse = this.charToMorse(key);
            ListaAlfabeticaRomano.add(key + " : " + Morse);
        }

        return ListaAlfabeticaRomano;
    }

    public ArrayList<String> DicionarioMorseRomano() {
        ArrayList<String> ListaAlfabeticaMorse = new ArrayList<>();

        for (String Morse : this.getCodes()) {
            Character character = this.morseToChar(Morse);
            ListaAlfabeticaMorse.add(Morse + " : " + character);
        }

        return ListaAlfabeticaMorse;
    }
}
