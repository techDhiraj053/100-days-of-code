/*
2694. Event Emitter (Advanced Data Structures - Day 33)

Implementing a foundational Publisher-Subscriber (Pub/Sub) pattern. 
Instead of using standard Arrays and Objects (which result in an O(n) 
time complexity bottleneck when filtering out unsubscribed callbacks), 
this solution utilizes modern JS Map and Set data structures. This 
achieves highly performant O(1) time complexity for callback deletions.
*/

class EventEmitter {
  constructor() {
    // Map is optimized for frequent key additions and removals
    this.events = new Map();
  }

  /**
   * @param {string} eventName
   * @param {Function} callback
   * @return {Object}
   */
  subscribe(eventName, callback) {
    if (!this.events.has(eventName)) {
      // Set maintains insertion order and provides O(1) deletion
      this.events.set(eventName, new Set());
    }

    const eventCallbacks = this.events.get(eventName);
    eventCallbacks.add(callback);

    return {
      unsubscribe: () => {
        // O(1) time complexity removal
        // This completely eliminates the O(N) bottleneck of Array.filter()
        eventCallbacks.delete(callback);
      },
    };
  }

  /**
   * @param {string} eventName
   * @param {Array} args
   * @return {Array}
   */
  emit(eventName, args = []) {
    if (!this.events.has(eventName)) {
      return [];
    }

    // Array.from() converts the Set back to an array so we can map over the results
    return Array.from(this.events.get(eventName)).map((cb) => cb(...args));
  }
}

/**
 * const emitter = new EventEmitter();
 * function onClickCallback() { return 99; }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 * console.log(emitter.emit('onClick')); // [99]
 * sub.unsubscribe();
 * console.log(emitter.emit('onClick')); // []
 */
