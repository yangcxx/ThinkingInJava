package cn.yangcx.enum19;

import cn.yangcx.util.Enums;

import java.util.Iterator;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/8/31 7:24
 */
public class PostOffice {

    enum MailHandler {

        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail m) {
                if (m.generalDelivery == Mail.GeneralDelivery.YES) {
                    print("Using general delivery for " + m);
                    return true;
                }
                return false;
            }
        },
        MACHINE_SCAN {
            boolean handle(Mail m) {
                if (m.scannability == Mail.Scannability.UNSCANNABLE) {
                    return false;
                }
                if (m.address == Mail.Address.INCORRECT) {
                    return false;
                }
                print("Delivering " + m + " automatically");
                return true;
            }
        },
        VISUAL_INSPECTION {
            boolean handle(Mail m) {
                if (m.readability == Mail.Readability.ILLEGIBLE) {
                    return false;
                }
                if (m.address == Mail.Address.INCORRECT) {
                    return false;
                }
                print("Delivering " + m + " normally");
                return true;
            }
        },
        RETURN_TO_SENDER {
            boolean handle(Mail m) {
                if (m.returnAddress == Mail.ReturnAddress.MISSING) {
                    return false;
                }
                print("Returning " + m + " to sender");
                return true;
            }
        };

        abstract boolean handle(Mail m);
    }

    static void handle(Mail m) {
        // todo 责任链；enum的次序即是定义顺序
        for (MailHandler handler : MailHandler.values()) {
            if (handler.handle(m)) {
                return;
            }
            print(m + " is a dead letter");
        }
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(10)) {
            print(mail.details());
            handle(mail);
            print("******");
        }
    }

}

class Mail {
    // The NO's lower the probability of random selection:
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return this +
                ", General Delivery: " + generalDelivery +
                ", Address Scanability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }

    // Generate test Mail:
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {

            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
