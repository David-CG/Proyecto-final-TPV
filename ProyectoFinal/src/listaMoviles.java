import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class listaMoviles {
    List<telefonoMovil> listaMoviles = new List<telefonoMovil>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<telefonoMovil> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(telefonoMovil telefonoMovil) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends telefonoMovil> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends telefonoMovil> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public telefonoMovil get(int index) {
            return null;
        }

        @Override
        public telefonoMovil set(int index, telefonoMovil element) {
            return null;
        }

        @Override
        public void add(int index, telefonoMovil element) {

        }

        @Override
        public telefonoMovil remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<telefonoMovil> listIterator() {
            return null;
        }

        @Override
        public ListIterator<telefonoMovil> listIterator(int index) {
            return null;
        }

        @Override
        public List<telefonoMovil> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
}
