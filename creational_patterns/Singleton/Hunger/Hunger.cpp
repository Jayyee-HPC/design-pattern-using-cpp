#include <utility>
#include <cstdlib>

template <class Derived>
class Hunger
{
public:
    template <typename... Args>
    static inline Derived &getInstance(Args &&... args)
    {
        return *getInstancePointer(std::forward<Args>(args)...);
    }

    template <typename... Args>
    static inline Derived *getInstance(Args &&... args)
    {
        static Derived *instancePointer = createInstance(std::forward<Args>(args)...);
        return instancePointer;
    }

protected:
    // Constructors
    Hunger(void) = default;

    Hunger(Hunger const &) = default;

    Hunger(Hunger &&) = default;

    // Assignment Operators
    Hunger &operator=(Hunger const &) = default;

    Hunger &operator=(Hunger &&) = default;

    // Destructor
    virtual ~Hunger(void) = default;  


private:
    // Static Attributes
	static Derived *instancePointer;

    // Static Methods
	template <typename... Args>
    static inline Derived *CreateInstance(Args &&...args)
    {
        if (Hunger::InstancePointer == nullptr)
        {
            void *data = static_cast<void *>(GetData());
            new (data) Derived(std::forward<Args>(args)...);

            Hunger::InstancePointer = reinterpret_cast<Derived *>(data);

            std::atexit(&Hunger::DestroyInstance);
        }

        return Hunger::InstancePointer;
    }

    static inline void DestroyInstance(void)
    {
        reinterpret_cast<Derived *>(GetData())->~Derived();
    }

    static inline unsigned char *GetData(void)
    {
        static unsigned char data[sizeof(Derived)];
        return data;
    }
};

int main()
{
    return 0;
}